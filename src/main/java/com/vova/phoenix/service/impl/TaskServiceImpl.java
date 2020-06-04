package com.vova.phoenix.service.impl;

import com.vova.phoenix.model.po.entity.TaskConfig;
import com.vova.phoenix.service.TaskService;
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
}
