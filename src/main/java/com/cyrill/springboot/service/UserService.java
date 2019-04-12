package com.cyrill.springboot.service;

import com.cyrill.springboot.entity.User;

import java.util.List;

public interface UserService {
    User findUser(String userName,String password);
    boolean save (User user);
    User findUserById(Long id);
    List<User> findAllUser();
}
