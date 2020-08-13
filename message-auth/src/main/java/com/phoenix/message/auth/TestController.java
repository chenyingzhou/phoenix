package com.phoenix.message.auth;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
    @GetMapping("/hello")
    public Object hello() {
        return "hello";
    }

    @GetMapping("/test")
    public Object test() {
        return "test";
    }
}
