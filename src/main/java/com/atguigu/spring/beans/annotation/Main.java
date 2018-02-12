package com.atguigu.spring.beans.annotation;

import com.atguigu.spring.beans.annotation.controller.UserCollector;
import com.atguigu.spring.beans.annotation.repository.UserRepository;
import com.atguigu.spring.beans.annotation.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("beans-annotation.xml");

//        TestObject to = (TestObject) ctx.getBean("testObject");
//        System.out.println(to);

        UserCollector userCollector = (UserCollector)ctx.getBean("userCollector");
        System.out.println(userCollector);
        userCollector.execute();

//        UserService userService = (UserService)ctx.getBean("userService");
//        System.out.println(userService);

//        UserRepository userRepository = (UserRepository)ctx.getBean("userRepository");
//        System.out.println(userRepository);
    }
}
