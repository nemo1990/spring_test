package com.atguigu.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class HelloDao{
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Hello get(Integer id){
        String sql = "SELECT id, name, sex FROM hello where id = ?";
        RowMapper<Hello> rowMapper = new BeanPropertyRowMapper<>(Hello.class);
        Hello hello = jdbcTemplate.queryForObject(sql, rowMapper, 1);
        return hello;
    }
}
