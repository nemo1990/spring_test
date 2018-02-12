package com.atguigu.spring.beans.factorybean;

import org.springframework.beans.factory.FactoryBean;

//自定义的FactoryBean需要实现FactoryBean接口
public class CarFactoryBean implements FactoryBean<Car>{
    private String brand;

    public void setBrand(String brand) {
        this.brand = brand;
    }

    //返回bean的对象
    public Car getObject() {
        return new Car(brand, 500000);
    }

    //返回Bean的类型
    public Class<?> getObjectType() {
        return Car.class;
    }

    public boolean isSingleton() {
        return true;
    }
}
