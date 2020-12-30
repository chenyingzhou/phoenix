package com.phoenix.message.job.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TaskSplitSchedule {
    @Scheduled(fixedDelay = 60000)
    void createTask() {

    }
}
