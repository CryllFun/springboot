package com.cyrill.springboot.service.impl;

import com.cyrill.springboot.dao.mapper.donation.UserMapper;
import com.cyrill.springboot.entity.User;
import com.cyrill.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public User findUser(String userName, String password) {
        User user = null;
        try {
            user = userMapper.findUserByPass(userName,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean save(User user) {
        try {
            userMapper.insert(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    @Override
    public User findUserById(Long id) {
        try {
            return userMapper.getOne(id);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<User> findAllUser() {

        try {
            return userMapper.getAll();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

}
