package com.vova.phoenix.controller;

import com.vova.phoenix.model.converter.beancopy.CachedBeanCopier;
import com.vova.phoenix.model.dto.BaseListResponse;
import com.vova.phoenix.model.dto.request.TaskConfigFilterReq;
import com.vova.phoenix.model.dto.response.task.TaskConfigResp;
import com.vova.phoenix.model.po.entity.TaskConfig;
import com.vova.phoenix.util.JacksonUtil;
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
