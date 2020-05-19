package com.vova.phoenix.controller;

import com.vova.phoenix.model.converter.beancopy.CachedBeanCopier;
import com.vova.phoenix.model.dto.BaseListResponse;
import com.vova.phoenix.model.dto.request.TaskConfigFilterReq;
import com.vova.phoenix.model.po.entity.TaskConfig;
import com.vova.phoenix.model.vo.TaskConfigFilter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController extends BaseController {
    @GetMapping("/taskConfig")
    public BaseListResponse<TaskConfig> list(TaskConfigFilterReq taskConfigFilterReq) {
        var taskConfigFilter = new TaskConfigFilter();
        CachedBeanCopier.copy(taskConfigFilterReq, taskConfigFilter);
        var taskConfigList = taskService.findTaskConfigByFilter(taskConfigFilter);
        return this.sendList(taskConfigList);
    }

}
