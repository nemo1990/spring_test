package com.atguigu.spring.beans;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        /*
        //创建对象
        HelloWorld helloWorld = new HelloWorld();
        //赋值
        helloWorld.setName("atguigu");
        */

        //1.创建Spring的IOC容器对象
        //ApplicationContext代表IOC容器
        //ClassPathXmlApplicationContext是ApplicationContext接口的实现类，该实现类从类路径下来加载配置文件
        ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
        //2.从IOC容器中获取Bean实例
        //利用id定位到IOC容器中的bean
//        HelloWorld helloWorld = (HelloWorld)ctx.getBean("helloWorld");
        //利用类型返回IOC容器中的bean，要求容器中只有一个该类型的bean
//        HelloWorld helloWorld = ctx.getBean(HelloWorld.class);

        //调用方法
//        helloWorld.hello();

//        Car car = (Car) ctx.getBean("car");
//        System.out.println(car);
//
//        car = (Car) ctx.getBean("car2");
//        System.out.println(car);
//
        Person person = (Person) ctx.getBean("person3");
        System.out.println(person);
    }
}
