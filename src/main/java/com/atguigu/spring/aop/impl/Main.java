package com.atguigu.spring.aop.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        //创建Spring的IOC容器
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext2.xml");
        //从IOC容器中获取bean实例
        ArithmeticCalculator arithmeticCalculator = (ArithmeticCalculator)ctx.getBean("arithmeticCalculatorImpl");

        System.out.println(arithmeticCalculator.getClass().getName());
        //使用bean
        int result = arithmeticCalculator.add(3, 6);
        System.out.println("result:" + result);

        result = arithmeticCalculator.div(12, 3);
        System.out.println("result:" + result);
    }
}
