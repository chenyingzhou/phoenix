package com.phoenix.message.common.service.impl;

import com.phoenix.message.common.entity.TaskProcess;
import com.phoenix.message.common.mapper.TaskProcessMapper;
import com.phoenix.message.common.service.TaskProcessService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 任务进程 服务实现类
 * </p>
 *
 * @author nome
 * @since 2020-12-29
 */
@Service
public class TaskProcessServiceImpl extends ServiceImpl<TaskProcessMapper, TaskProcess> implements TaskProcessService {

}
