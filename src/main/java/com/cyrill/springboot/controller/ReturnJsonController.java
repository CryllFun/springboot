package com.cyrill.springboot.controller;

import java.util.List;

import com.cyrill.springboot.util.Result;
import com.cyrill.springboot.entity.User;
import com.cyrill.springboot.dao.hibernate.UserRepository;
import com.cyrill.springboot.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController//返回json格式
public class ReturnJsonController {
    private static Logger logger = LoggerFactory.getLogger(ReturnJsonController.class);
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
    @RequestMapping("/getUserInfo")
    public Result getUserInfo(Long id, String action,String page,String size){
        Result result = new Result();
        try {
            switch (action){
                case "self":
                    User user =  userRepository.findUserById(id);
                    result.setObj(user);
                    break;
                case "allUser":
                    //分页查询
//                    Pageable pageable = PageRequest.of(pageIndex,pageSize,Sort.Direction.ASC,"id");
//                    Page<User> page = userRepository.findAll(pageable);
//                    result.setPager(page);没有content？？？
                    List<User> list = userRepository.findAll();
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
