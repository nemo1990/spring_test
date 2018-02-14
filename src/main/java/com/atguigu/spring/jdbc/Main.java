package com.atguigu.spring.jdbc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext ctx = new ClassPathXmlApplicationContext("dbContext.xml");
        HelloDao helloDao = (HelloDao)ctx.getBean("helloDao");
        HelloDao2 helloDao2 = (HelloDao2)ctx.getBean("helloDao2");
        System.out.println(helloDao.get(1));
        System.out.println(helloDao2.get(2));
    }
}
