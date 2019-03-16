package com.cyrill.springboot.service.impl;

import com.cyrill.springboot.dao.hibernate.UserRepository;
import com.cyrill.springboot.entity.User;
import com.cyrill.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Override
    public User findUser(String userName, String password) {
        User user = null;
        try {
            user = userRepository.findByUserNameAndPassWord(userName,password);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

    @Override
    public boolean save(User user) {
        try {
            userRepository.save(user);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
