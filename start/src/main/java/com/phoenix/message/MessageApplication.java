package com.phoenix.message;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import tk.mybatis.spring.annotation.MapperScan;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EnableDiscoveryClient
@MapperScan("com.phoenix.message.common.mapper")
public class MessageApplication {

    @PostConstruct
    void started() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }

    public static void main(String[] args) {
        SpringApplication.run(MessageApplication.class, args);
    }

}
