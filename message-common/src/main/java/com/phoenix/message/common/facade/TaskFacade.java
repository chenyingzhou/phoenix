package com.phoenix.message.common.facade;

import com.phoenix.message.common.dto.Pagination;
import com.phoenix.message.common.dto.TaskConfigDto;
import com.phoenix.message.common.dto.TaskConfigFilterDto;
import com.phoenix.message.common.dto.TaskDto;

import java.util.List;

public interface TaskFacade {
    static final int TASK_STATUS_READY = 0;
    static final int TASK_STATUS_RUNNING = 1;
    static final int TASK_STATUS_COMPLETED = 2;
    static final int TASK_STATUS_TERMINATED = 3;

    Pagination<TaskConfigDto> findTaskConfigWithPagination(TaskConfigFilterDto taskConfigFilterDto);
    TaskConfigDto findTaskConfigById(Integer id);
    List<TaskConfigDto> findRunningTaskConfigList();
    Integer saveTaskConfig(TaskConfigDto taskConfigDto);
    Boolean saveTaskList(List<TaskDto> taskDtoList);
}
