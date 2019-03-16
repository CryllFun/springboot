package com.cyrill.springboot.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cyrill.springboot.entity.User;
import com.cyrill.springboot.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/")
    public  String toLogin(){
        return "login";
    }
    @RequestMapping(value = "/login")
    public  String login(Model model,String userName,String password){
        User user = userService.findUser(userName,password);
        if (user==null){
            model.addAttribute("msg","登录名或密码错误！");
            return "login";
        }
        model.addAttribute("user",user);
        return "homePage";
    }
}
