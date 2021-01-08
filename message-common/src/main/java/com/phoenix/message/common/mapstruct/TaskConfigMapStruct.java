package com.phoenix.message.common.mapstruct;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.phoenix.message.common.dto.JsonColumn;
import com.phoenix.message.common.dto.Pagination;
import com.phoenix.message.common.dto.TaskConfigDto;
import com.phoenix.message.common.dto.TaskDto;
import com.phoenix.message.common.dto.taskconfig.TaskConfigAccountConfigDto;
import com.phoenix.message.common.dto.taskconfig.TaskConfigContentConfigDto;
import com.phoenix.message.common.dto.taskconfig.TaskConfigUserConfigDto;
import com.phoenix.message.common.dto.taskconfig.TaskConfigVersionConfigDto;
import com.phoenix.message.common.entity.Task;
import com.phoenix.message.common.entity.TaskConfig;
import com.phoenix.message.common.util.JacksonUtil;
import org.mapstruct.*;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper()
public interface TaskConfigMapStruct extends BaseMapStruct {
    TaskConfigMapStruct INSTANCE = Mappers.getMapper(TaskConfigMapStruct.class);

    default String JsonColumn2Json(JsonColumn jsonColumn) {
        return JacksonUtil.toJson(jsonColumn);
    }

    default TaskConfigUserConfigDto String2TaskConfigUserConfigDto(String content) {
        return JacksonUtil.toObject(content, TaskConfigUserConfigDto.class);
    }

    default TaskConfigContentConfigDto String2TaskConfigContentConfigDto(String content) {
        return JacksonUtil.toObject(content, TaskConfigContentConfigDto.class);
    }

    default TaskConfigVersionConfigDto String2TaskConfigVersionConfigDto(String content) {
        return JacksonUtil.toObject(content, TaskConfigVersionConfigDto.class);
    }

    default TaskConfigAccountConfigDto String2TaskConfigAccountConfigDto(String content) {
        return JacksonUtil.toObject(content, TaskConfigAccountConfigDto.class);
    }

    Pagination<TaskConfigDto> entity2Dto(Page<TaskConfig> taskConfigPage);

    TaskConfigDto entity2Dto(TaskConfig taskConfig);

    List<TaskConfigDto> entity2Dto(List<TaskConfig> taskConfigList);

    TaskConfig dto2Entity(TaskConfigDto taskConfigDto);
}
