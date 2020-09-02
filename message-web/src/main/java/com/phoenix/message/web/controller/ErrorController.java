package com.phoenix.message.web.controller;

import com.phoenix.message.web.model.BaseResponse;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class ErrorController extends BasicErrorController {
    public ErrorController(ServerProperties serverProperties) {
        super(new DefaultErrorAttributes(), serverProperties.getError());
    }

    @Override
    public ResponseEntity<Map<String, Object>> error(HttpServletRequest request) {
        HttpStatus status = getStatus(request);

        BaseResponse<?> response = new BaseResponse<>();
        response.setCode(status.value());
        response.setMsg((String) getErrorAttributes(request, ErrorAttributeOptions.defaults()).get("error"));

        return new ResponseEntity<>(response.toMap(), status);
    }
}
