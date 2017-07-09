package com.baron.program;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by Administrator on 2017/7/3 0003.
 */
@SpringBootApplication
@EnableEurekaServer
@ComponentScan
public class EurekaServerC {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServerC.class, args);
    }
}
