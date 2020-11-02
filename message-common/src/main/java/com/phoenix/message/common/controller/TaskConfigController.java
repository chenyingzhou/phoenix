package com.phoenix.message.common.controller;


import com.phoenix.message.common.service.TaskConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 * 推送任务配置表 前端控制器
 * </p>
 *
 * @author nome
 * @since 2020-11-02
 */
@RestController
public class TaskConfigController {
    @Autowired
    TaskConfigService taskConfigService;

    @GetMapping("/test1")
    public String test1() {
        var a = taskConfigService.getById(1);
        return null;
    }

}

