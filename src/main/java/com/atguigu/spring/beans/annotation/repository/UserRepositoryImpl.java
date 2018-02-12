package com.atguigu.spring.beans.annotation.repository;

import com.atguigu.spring.beans.annotation.TestObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepositoryImpl implements UserRepository{
    @Autowired(required = false)
    private TestObject testObject;

    public void save() {
        System.out.println("UserRepositoryImpl Save...");
        System.out.println(testObject);
    }
}
