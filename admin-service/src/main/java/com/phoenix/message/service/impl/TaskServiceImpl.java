package com.phoenix.message.service.impl;

import com.phoenix.message.model.po.entity.TaskConfig;
import com.phoenix.message.service.TaskService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
public class TaskServiceImpl implements TaskService {

    private final TaskService dbService;

    public TaskServiceImpl(@Qualifier("dbTaskService") TaskService dbService) {
        this.dbService = dbService;
    }

    @Override
    public TaskConfig findTaskConfig(Integer id) {
        return dbService.findTaskConfig(id);
    }

    @Override
    public List<TaskConfig> findTaskConfigList(List<Integer> idList) {
        return dbService.findTaskConfigList(idList);
    }

    @Override
    public List<TaskConfig> findTaskConfigList(TaskConfig taskConfig) {
        return dbService.findTaskConfigList(taskConfig);
    }

    @Override
    public boolean insertTaskConfig(TaskConfig taskConfig) {
        return dbService.insertTaskConfig(taskConfig);
    }

    @Override
    public boolean updateTaskConfig(TaskConfig taskConfig) {
        return dbService.updateTaskConfig(taskConfig);
    }

}
