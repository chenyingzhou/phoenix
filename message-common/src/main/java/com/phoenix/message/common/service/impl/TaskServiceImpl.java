package com.phoenix.message.common.service.impl;

import com.phoenix.message.common.entity.Task;
import com.phoenix.message.common.mapper.TaskMapper;
import com.phoenix.message.common.service.TaskService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 任务 服务实现类
 * </p>
 *
 * @author nome
 * @since 2020-12-29
 */
@Service
public class TaskServiceImpl extends ServiceImpl<TaskMapper, Task> implements TaskService {

}
