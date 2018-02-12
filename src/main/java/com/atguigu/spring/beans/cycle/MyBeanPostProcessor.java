package com.atguigu.spring.beans.cycle;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class MyBeanPostProcessor implements BeanPostProcessor{
    public Object postProcessBeforeInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessorBeforeInitialization:" + o +"," + s);
        //会对所有bean处理 可以进行过滤处理
        if("car".equals(s)){
            //...
        }
        return o;
    }

    public Object postProcessAfterInitialization(Object o, String s) throws BeansException {
        System.out.println("postProcessorAfterInitialization:" + o +"," + s);
        //生成了一个新的实例并返回
        Car car = new Car();
        car.setBrand("Ford");
        return car;
    }
}
