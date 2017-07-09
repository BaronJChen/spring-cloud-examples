package com.baron.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by Jason on 2017/7/9.
 */
@RestController
public class ControllerB {
    @RequestMapping()
    public String hello() {
        return "hello, this is service b";
    }
}
