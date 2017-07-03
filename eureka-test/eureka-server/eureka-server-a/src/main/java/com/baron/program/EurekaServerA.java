package com.baron.program;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by Administrator on 2017/7/3 0003.
 */
@SpringBootApplication
@EnableEurekaServer
public class EurekaServerA {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerA.class, args);
    }
}
