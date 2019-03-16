package com.cyrill.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
@Entity
public class User implements Serializable {
    //    不映射成列的字段得加@Transient注解,不加注解也会映射成列
    @Id
    @GeneratedValue
    private Long id;
    @Column(nullable = false,unique = true)
    private  String userName;
    @Column(nullable = false)
    private String passWord;
    @Column(nullable = true,unique = true)
    private String email;
    @Column(nullable = true,unique = true)
    private String nickName;
    @Column(nullable = true)
    private String regTime;

    public User() {
    }

    public User(String userName, String passWord) {
        this.userName = userName;
        this.passWord = passWord;
    }

    public User(String userName, String email, String nickName, String passWord, String regTime) {
        this.userName = userName;
        this.passWord = passWord;
        this.email = email;
        this.nickName = nickName;
        this.regTime = regTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRegTime() {
        return regTime;
    }

    public void setRegTime(String regTime) {
        this.regTime = regTime;
    }
}
