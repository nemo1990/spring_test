package com.atguigu.spring.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;

/*
 * 不推荐使用JdbcDaoSupport，而推荐直接使用JdbcTemplate作为Dao类的成员变量
 */
@Repository
public class HelloDao2 extends JdbcDaoSupport{
    @Autowired
    public void setDataSource2(DataSource dataSource){
        setDataSource(dataSource);
    }

    public Hello get(Integer id){
        String sql = "SELECT id, name, sex FROM hello where id = ?";
        RowMapper<Hello> rowMapper = new BeanPropertyRowMapper<>(Hello.class);
        return getJdbcTemplate().queryForObject(sql, rowMapper, id);
    }
}
