package com.baron.program;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Administrator on 2017/7/3 0003.
 */
@SpringBootApplication
@EnableEurekaClient
@ComponentScan("com.baron")
public class GoodbyeServiceB {
    public static void main(String[] args) {
        SpringApplication.run(GoodbyeServiceB.class, args);
    }
}
