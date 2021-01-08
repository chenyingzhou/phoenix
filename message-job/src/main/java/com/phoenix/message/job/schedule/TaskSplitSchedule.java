package com.phoenix.message.job.schedule;

import com.phoenix.message.common.dto.TaskConfigDto;
import com.phoenix.message.common.dto.TaskDto;
import com.phoenix.message.common.facade.TaskFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class TaskSplitSchedule {
    private final TaskFacade taskFacade;

    @Autowired
    public TaskSplitSchedule(TaskFacade taskFacade) {
        this.taskFacade = taskFacade;
    }

    @Scheduled(fixedDelay = 60000)
    void createTask() {
        List<TaskConfigDto> taskConfigDtoList = taskFacade.findRunningTaskConfigList();
        List<Integer> timeOffsetList = IntStream.range(-12, 15).boxed().collect(Collectors.toList());
        List<TaskDto> taskDtoList = new ArrayList<>();
        for (TaskConfigDto taskConfigDto : taskConfigDtoList) {
            LocalDateTime nextSendTime = taskConfigDto.getSendTime();
            if (taskConfigDto.getRecordTime() != null) {
                nextSendTime = taskConfigDto.getRecordTime().plusDays(taskConfigDto.getPeriod());
            }
            if (nextSendTime.equals(taskConfigDto.getRecordTime())) {
                continue;
            }
            for (Integer timeOffset : timeOffsetList) {
                TaskDto taskDto = new TaskDto();
                taskDto.setConfigId(taskConfigDto.getId());
                taskDto.setTimeOffset(timeOffset);
                taskDto.setSendTime(nextSendTime.plusHours(-timeOffset));
                taskDtoList.add(taskDto);
            }
        }
        taskFacade.saveTaskList(taskDtoList);
    }
}
