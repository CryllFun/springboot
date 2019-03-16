package com.cyrill.springboot.service;

import com.cyrill.springboot.entity.User;

public interface UserService {
    User findUser(String userName,String password);
    boolean save (User user);
}
