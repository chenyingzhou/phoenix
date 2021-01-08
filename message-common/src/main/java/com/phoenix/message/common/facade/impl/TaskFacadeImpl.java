package com.phoenix.message.common.facade.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.phoenix.message.common.dto.Pagination;
import com.phoenix.message.common.dto.TaskConfigDto;
import com.phoenix.message.common.dto.TaskConfigFilterDto;
import com.phoenix.message.common.dto.TaskDto;
import com.phoenix.message.common.entity.Task;
import com.phoenix.message.common.entity.TaskConfig;
import com.phoenix.message.common.facade.TaskFacade;
import com.phoenix.message.common.mapstruct.TaskConfigMapStruct;
import com.phoenix.message.common.mapstruct.TaskMapStruct;
import com.phoenix.message.common.service.TaskConfigService;
import com.phoenix.message.common.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class TaskFacadeImpl implements TaskFacade {

    private final TaskConfigService taskConfigService;
    private final TaskService taskService;

    @Autowired
    TaskFacadeImpl(TaskConfigService taskConfigService, TaskService taskService) {
        this.taskConfigService = taskConfigService;
        this.taskService = taskService;
    }

    @Override
    public Pagination<TaskConfigDto> findTaskConfigWithPagination(TaskConfigFilterDto taskConfigFilterDto) {
        Page<TaskConfig> page = new Page<>();
        QueryWrapper<TaskConfig> queryWrapper = new QueryWrapper<>();
        if (taskConfigFilterDto.getCurrent() != null) {
            page.setCurrent(taskConfigFilterDto.getCurrent());
        }
        if (taskConfigFilterDto.getSize() != null) {
            page.setSize(taskConfigFilterDto.getSize());
        }
        if (taskConfigFilterDto.getId() != null) {
            queryWrapper.eq(TaskConfig.ID, taskConfigFilterDto.getId());
        }
        if (taskConfigFilterDto.getType() != null) {
            queryWrapper.eq(TaskConfig.TYPE, taskConfigFilterDto.getType());
        }
        if (taskConfigFilterDto.getClassification() != null) {
            queryWrapper.eq(TaskConfig.CLASSIFICATION, taskConfigFilterDto.getClassification());
        }
        if (taskConfigFilterDto.getAppName() != null) {
            queryWrapper.eq(TaskConfig.APP_NAME, taskConfigFilterDto.getAppName());
        }
        if (taskConfigFilterDto.getStatus() != null) {
            queryWrapper.eq(TaskConfig.STATUS, taskConfigFilterDto.getStatus());
        }
        if (taskConfigFilterDto.getCreateTimeStart() != null) {
            queryWrapper.ge(TaskConfig.CREATE_TIME, taskConfigFilterDto.getCreateTimeStart());
        }
        if (taskConfigFilterDto.getCreateTimeEnd() != null) {
            queryWrapper.ge(TaskConfig.CREATE_TIME, taskConfigFilterDto.getCreateTimeEnd());
        }
        taskConfigService.page(page, queryWrapper);
        return TaskConfigMapStruct.INSTANCE.entity2Dto(page);
    }

    @Override
    public TaskConfigDto findTaskConfigById(Integer id) {
        if (id == null || id <= 0) {
            return null;
        }
        TaskConfig taskConfig = taskConfigService.getById(id);
        return TaskConfigMapStruct.INSTANCE.entity2Dto(taskConfig);
    }

    public List<TaskConfigDto> findRunningTaskConfigList() {
        LocalDateTime now = LocalDateTime.now();
        QueryWrapper<TaskConfig> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(TaskConfig.STATUS, TASK_STATUS_RUNNING);
        queryWrapper.lt(TaskConfig.RECORD_TIME, now);
        queryWrapper.and(wrapper -> wrapper.le(TaskConfig.START_TIME, now).or().eq(TaskConfig.START_TIME, "0000-00-00"));
        queryWrapper.and(wrapper -> wrapper.ge(TaskConfig.END_TIME, now).or().eq(TaskConfig.END_TIME, "0000-00-00"));
        List<TaskConfig> taskConfigList = taskConfigService.list(queryWrapper);
        return TaskConfigMapStruct.INSTANCE.entity2Dto(taskConfigList);
    }

    @Override
    public Integer saveTaskConfig(TaskConfigDto taskConfigDto) {
        TaskConfig taskConfig = TaskConfigMapStruct.INSTANCE.dto2Entity(taskConfigDto);
        taskConfigService.saveOrUpdate(taskConfig);
        return taskConfig.getId();
    }

    public Boolean saveTaskList(List<TaskDto> taskDtoList) {
        List<Task> taskList = TaskMapStruct.INSTANCE.dto2Entity(taskDtoList);
        Boolean result = taskService.saveOrUpdateBatch(taskList);
        if (result) {
            taskDtoList.clear();
            taskDtoList.addAll(TaskMapStruct.INSTANCE.entity2Dto(taskList));
        }
        return result;
    }
}
