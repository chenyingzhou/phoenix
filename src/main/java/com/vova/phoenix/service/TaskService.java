package com.vova.phoenix.service;

import com.vova.phoenix.mapper.TaskConfigMapper;
import com.vova.phoenix.model.po.entity.TaskConfig;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaskService {
    @Resource
    private TaskConfigMapper taskConfigMapper;

    public List<TaskConfig> findTaskConfigByModel(TaskConfig taskConfig) {
        var example = new Example(TaskConfig.class);
        example.createCriteria().andEqualTo(taskConfig);
        return taskConfigMapper.selectByExample(example);
    }
}
