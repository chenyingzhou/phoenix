package com.phoenix.message.web.controller;

import com.phoenix.message.common.entity.PushTaskConfig;
import com.phoenix.message.web.model.BaseListResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PushController extends BaseController {

    @GetMapping("/push/task-config")
    public BaseListResponse<PushTaskConfig> taskConfig() {
        return sendList(pushService.findAllTaskConfig());
    }

}
