package com.phoenix.message.common.facade;

import com.phoenix.message.common.dto.Pagination;
import com.phoenix.message.common.dto.TaskConfigDto;
import com.phoenix.message.common.dto.TaskConfigFilterDto;

public interface TaskFacade {
    Pagination<TaskConfigDto> findTaskConfigWithPagination(TaskConfigFilterDto taskConfigFilterDto);
    TaskConfigDto findTaskConfigById(Integer id);
}
