package com.vova.phoenix.service;

import com.vova.phoenix.model.po.entity.TaskConfig;

import java.util.List;

public interface TaskService {
    public TaskConfig findTaskConfig(Integer id);

    public List<TaskConfig> findTaskConfigList(List<Integer> idList);

    public List<TaskConfig> findTaskConfigList(TaskConfig taskConfig);
}
