package com.cyrill.springboot.controller;

import java.util.List;

import com.cyrill.springboot.util.Result;
import com.cyrill.springboot.entity.User;
import com.cyrill.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController//返回json格式
public class ReturnJsonController {
    private static Logger logger = LoggerFactory.getLogger(ReturnJsonController.class);
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
    @RequestMapping("/getUserInfo")
    public Result getUserInfo(Long id, String action,String page,String size){
        Result result = new Result();
        try {
            switch (action){
                case "self":
                    User user =  userService.findUserById(id);
                    result.setObj(user);
                    break;
                case "allUser":
                    List<User> list = userService.findAllUser();
                    result.listToPage(list,page,size);
            }
            result.setErrCode(0);
        }catch (Exception e){
            result.setErrCode(-1);
            result.setErrMsg("获取用户信息出错！");
            e.printStackTrace();
            logger.info("getUserInfo抛出异常");
        }
        return  result;
    }

}
