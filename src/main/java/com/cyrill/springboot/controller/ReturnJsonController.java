package com.cyrill.springboot.controller;

import com.cyrill.springboot.entity.Properties;
import com.cyrill.springboot.entity.User;
import com.cyrill.springboot.dao.hibernate.UserRepository;
import com.cyrill.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.UUID;

@RestController//返回json格式
public class ReturnJsonController {
    @Autowired
    private Properties properties;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    @RequestMapping("/register")
    public String register(User user){
        boolean success = userService.save(user);
        if (success){
            return "注册成功!";

        }
        return "注册失败!";
    }
    @RequestMapping("/redisTest")
    @Cacheable(value="user-key")//自动根据方法生成缓存,其中value的值就是缓存到redis中的key
    public User getUser(){
        User user = userRepository.findByUserName("aa1");
        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
        return user;
    }
    //    获取session-id
    @RequestMapping("/getSessionId")
    String uid(HttpSession session){
        UUID uid = (UUID)session.getAttribute("uid");
        if (uid == null){
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid",uid);
        return  session.getId();
    }
    //测试jpa
    @RequestMapping("/getUser")
    public User japTest(){
        User user =  userRepository.findByEmail("bb@qq.com");
        return  user;
    }
}
