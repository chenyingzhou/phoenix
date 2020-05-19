package com.vova.phoenix.service;

import com.vova.phoenix.mapper.TaskConfigMapper;
import com.vova.phoenix.model.po.entity.TaskConfig;
import com.vova.phoenix.model.vo.TaskConfigFilter;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
public class TaskService {
    @Resource
    private TaskConfigMapper taskConfigMapper;

    public List<TaskConfig> findTaskConfigByFilter(TaskConfigFilter taskConfigFilter) {
        var example = new Example(TaskConfig.class);
        example.createCriteria().andEqualTo(taskConfigFilter);
        return taskConfigMapper.selectByExample(example);
    }
}
