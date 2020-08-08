package com.phoenix.message.auth;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/hello")
    @Secured("ROLE_ADMIN")
    public Object getCurrentUser(Authentication authentication) {
//        return "hello";
        return authentication.getPrincipal();
    }
}
