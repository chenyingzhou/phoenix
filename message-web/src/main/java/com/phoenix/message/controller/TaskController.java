package com.phoenix.message.controller;

import com.phoenix.message.model.dto.BaseListResponse;
import com.phoenix.message.model.dto.request.TaskConfigFilterReq;
import com.phoenix.message.model.dto.response.task.TaskConfigResp;
import com.phoenix.message.model.po.entity.TaskConfig;
import com.phoenix.message.util.JacksonUtil;
import com.phoenix.message.model.converter.beancopy.CachedBeanCopier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController extends BaseController {
    @GetMapping("/task/task-config")
    public BaseListResponse<TaskConfigResp> list(TaskConfigFilterReq taskConfigFilterReq) {
        var taskConfig = new TaskConfig();
        CachedBeanCopier.copy(taskConfigFilterReq, taskConfig);
        var taskConfigList = taskService.findTaskConfigList(taskConfig);
        var taskConfigRespList = JacksonUtil.toList(JacksonUtil.toJson(taskConfigList), TaskConfigResp.class);
        return this.sendList(taskConfigRespList);
    }

}
