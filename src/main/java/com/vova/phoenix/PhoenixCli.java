package com.vova.phoenix;

import com.vova.phoenix.task.StartupRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan("com.vova.phoenix.mapper")
public class PhoenixCli {

    @Bean
    public StartupRunner startupRunner() {
        return new StartupRunner();
    }

    public static void main(String[] args) {
        var ctx = SpringApplication.run(PhoenixCli.class, args);
        System.exit(SpringApplication.exit(ctx));
    }

}
