
package com.cyrill.springboot;

import com.cyrill.springboot.entity.User;
import com.cyrill.springboot.dao.hibernate.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.text.DateFormat;
import java.util.Date;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
@WebAppConfiguration
public class UserRepositoryTests {
    @Autowired
    private UserRepository userRepository;
    @Test
    public void test() throws Exception{
        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateInstance(DateFormat.LONG,DateFormat.getAvailableLocales()[0]);
        String formattedDate = dateFormat.format(date);
        userRepository.save(new User("a1","a1@qq.com","a1","a123456",formattedDate));
        userRepository.save(new User("b2","b2@qq.com","b1","b123456",formattedDate));
        userRepository.save(new User("c3","c3@qq.com","c1","c123456",formattedDate));
        Assert.assertEquals(9,userRepository.findAll().size());
        Assert.assertEquals("bb",userRepository.findByUserNameOrEmail("bb","cc@qq.com").getNickName());
        userRepository.delete(userRepository.findByUserName("aa1"));
    }
}
