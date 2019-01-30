package com.cyrill.springboot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController//可以以json格式输出
public class HelloWorldController {
    @RequestMapping("/hello")
    public String index() {
        return "Hello World!";
    }
}
