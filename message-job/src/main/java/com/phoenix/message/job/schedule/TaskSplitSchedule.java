package com.phoenix.message.job.schedule;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class TaskSplitSchedule {
    @Scheduled(cron = "*/10 * * * * ?")
    private void process() throws InterruptedException {
        Thread.sleep(10000000);
        System.out.println("SchedulerTask11 : " + LocalDateTime.now().toLocalTime());
    }
}
