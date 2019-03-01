package com.cyrill.springboot.controller;

import com.cyrill.springboot.dao.hibernate.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @RequestMapping("/toLogin")
    public  String toLogin(){
        System.out.println("转到登录页面");
        return "http://localhost:8080/templates/login.html";
    }
}
