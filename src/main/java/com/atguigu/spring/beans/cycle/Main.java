package com.atguigu.spring.beans.cycle;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;

public class Main {
    public static void main(String[] args) throws Exception{
        ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("beans-cycle.xml");

        Car car = (Car) ctx.getBean("car");
        System.out.println(car);

        //关闭IOC容器
        ctx.close();
    }
}
