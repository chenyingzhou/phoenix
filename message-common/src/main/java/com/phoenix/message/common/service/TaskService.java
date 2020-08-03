package com.phoenix.message.common.service;

import com.phoenix.message.common.model.po.entity.TaskConfig;

import java.util.List;

public interface TaskService {
    public TaskConfig findTaskConfig(Integer id);

    public List<TaskConfig> findTaskConfigList(List<Integer> idList);

    public List<TaskConfig> findTaskConfigList(TaskConfig taskConfig);

    public boolean insertTaskConfig(TaskConfig taskConfig);

    public boolean updateTaskConfig(TaskConfig taskConfig);
}