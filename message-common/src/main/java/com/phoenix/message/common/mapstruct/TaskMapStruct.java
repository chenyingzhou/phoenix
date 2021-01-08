package com.phoenix.message.common.mapstruct;

import com.phoenix.message.common.dto.TaskDto;
import com.phoenix.message.common.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper()
public interface TaskMapStruct extends BaseMapStruct {
    TaskMapStruct INSTANCE = Mappers.getMapper(TaskMapStruct.class);

    TaskDto entity2Dto(Task task);

    List<TaskDto> entity2Dto(List<Task> taskList);

    Task dto2Entity(TaskDto taskDto);

    List<Task> dto2Entity(List<TaskDto> taskDtoList);

}
