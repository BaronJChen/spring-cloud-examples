package com.baron.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * Created by Administrator on 2017/7/3 0003.
 */
@RestController
public class HelloControllerA {
    @Autowired
    RestTemplate restTemplate;

    @GetMapping("/hello")
    public String hello() {
        return "hi, this is hello service a, and " +  restTemplate.getForObject("http://GOODBYE-SERVICE/goodbye", String.class);
    }
}
