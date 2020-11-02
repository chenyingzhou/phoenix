package com.phoenix.message.common.service.impl;

import com.phoenix.message.common.entity.TaskConfig;
import com.phoenix.message.common.mapper.TaskConfigMapper;
import com.phoenix.message.common.service.TaskConfigService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 推送任务配置表 服务实现类
 * </p>
 *
 * @author nome
 * @since 2020-11-02
 */
@Service
public class TaskConfigServiceImpl extends ServiceImpl<TaskConfigMapper, TaskConfig> implements TaskConfigService {

}
