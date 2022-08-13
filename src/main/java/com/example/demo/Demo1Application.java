package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@MapperScan("com.example.demo.dao")
@SpringBootApplication

public class Demo1Application {

    public static void main(String[] args) {
        try {
            ConfigurableApplicationContext context = SpringApplication.run(Demo1Application.class, args);
            Environment environment = context.getBean(Environment.class);
            System.out.println("访问链接：http://localhost:" +environment.getProperty("server.port"));
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
