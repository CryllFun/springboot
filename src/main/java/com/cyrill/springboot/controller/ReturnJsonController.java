package com.cyrill.springboot.controller;

import com.cyrill.springboot.entity.Properties;
import com.cyrill.springboot.util.Result;
import com.cyrill.springboot.entity.User;
import com.cyrill.springboot.dao.hibernate.UserRepository;
import com.cyrill.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController//返回json格式
public class ReturnJsonController {
    @Autowired
    private Result result;
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
    public Result getUserInfo(long id, String action){
        try {
            switch (action){
                case "self":
                    User user =  userRepository.findById(id);
                    result.setObj(user);
                    break;
                case "allUser":
                    //分页查询
                    int pageIndex = 1,size = 10;
                    Sort sort = new Sort(Sort.Direction.ASC,"id");
                    Pageable pageable = new PageRequest(pageIndex,size,sort);
                    Page page = userRepository.findAll(pageable);
                    result.setPager(page);
            }
            result.setErrCode(0);
        }catch (Exception e){
            result.setErrCode(-1);
            result.setErrMsg(e.getMessage());
        }
        return  result;
    }

}
