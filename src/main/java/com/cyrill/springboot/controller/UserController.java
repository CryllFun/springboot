package com.cyrill.springboot.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.cyrill.springboot.entity.User;
import com.cyrill.springboot.service.UserService;
import org.apache.catalina.Session;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class UserController {
    @Resource
    private UserService userService;
    @RequestMapping("/")
    public  String toLogin(HttpSession session){
        session.removeAttribute("user");
        return "login";
    }
    @RequestMapping(value = "/login")
    public  String login(Model model, String userName, String password, HttpServletRequest req){
        User user = userService.findUser(userName,password);
        HttpSession session = req.getSession();
        if (user==null){
            model.addAttribute("msg","登录名或密码错误！");
            return "login";
        }
        session.setAttribute("user",user);
        return "homepage";
    }
}
