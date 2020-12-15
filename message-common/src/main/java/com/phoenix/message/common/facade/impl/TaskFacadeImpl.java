package com.phoenix.message.common.facade.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.phoenix.message.common.dto.Pagination;
import com.phoenix.message.common.dto.TaskConfigDto;
import com.phoenix.message.common.dto.TaskConfigFilterDto;
import com.phoenix.message.common.entity.TaskConfig;
import com.phoenix.message.common.facade.TaskFacade;
import com.phoenix.message.common.mapstruct.TaskConfigMapStruct;
import com.phoenix.message.common.service.TaskConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TaskFacadeImpl implements TaskFacade {
    @Autowired
    private TaskConfigService taskConfigService;

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
}
