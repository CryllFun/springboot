package com.cyrill.springboot.dao.hibernate;

import com.cyrill.springboot.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//继承JpaRepository可以根据方法名生成sql语句
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAll();
    User findByUserName(String userName);
//    @Query("SELECT count(u.id) from User u where  u.userName = ?1 and u.passWord = ?2")
    User findByUserNameAndPassWord(String userName,String password);
    User findByUserNameOrEmail(String username,String email);
    //也可以通过注解的方式自定义生成sql语句
    @Modifying//涉及到删除和修改时需要此注解
    @Query("update User u set u.userName = ?1 where u.id = ?2")
    int updateUser(String  userName, Long id);

    @Transactional//对事务的支持
    @Modifying
    @Query("delete from User where id = ?1")
    void deleteByUserId(Long id);

    @Transactional(timeout = 10)//查询超时的设置
    @Query("select u from User u where u.email = ?1")
    User findByEmail(String email);
}
