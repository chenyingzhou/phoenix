package com.vova.phoenix.service.impl.db;

import com.vova.phoenix.mapper.TaskConfigMapper;
import com.vova.phoenix.model.po.entity.AdminUser;
import com.vova.phoenix.model.po.entity.TaskConfig;
import com.vova.phoenix.service.TaskService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class DbTaskService implements TaskService {
    @Resource
    private TaskConfigMapper taskConfigMapper;

    @Override
    public TaskConfig findTaskConfig(Integer id) {
        if (null == id) {
            return null;
        }
        var example = new Example(AdminUser.class);
        example.createCriteria().andEqualTo(TaskConfig.ID, id);
        return taskConfigMapper.selectOneByExample(example);
    }

    @Override
    public List<TaskConfig> findTaskConfigList(List<Integer> idList) {
        if (CollectionUtils.isEmpty(idList)) {
            return new ArrayList<>();
        }
        var example = new Example(AdminUser.class);
        example.createCriteria().andIn(TaskConfig.ID, idList);
        return taskConfigMapper.selectByExample(example);
    }

    @Override
    public List<TaskConfig> findTaskConfigList(TaskConfig taskConfig) {
        var example = new Example(TaskConfig.class);
        example.createCriteria().andEqualTo(taskConfig);
        return taskConfigMapper.selectByExample(example);
    }
}
