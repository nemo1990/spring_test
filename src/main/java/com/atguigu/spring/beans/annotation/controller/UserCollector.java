package com.atguigu.spring.beans.annotation.controller;

import com.atguigu.spring.beans.annotation.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UserCollector {
    @Autowired
    private UserService userService;


    public void execute(){
        System.out.println("UserController execute...");
        userService.add();
    }
}
