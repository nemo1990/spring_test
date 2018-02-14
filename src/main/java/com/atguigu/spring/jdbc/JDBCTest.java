package com.atguigu.spring.jdbc;


import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCTest {
    private ApplicationContext ctx = null;
    private JdbcTemplate jdbcTemplate = null;
    private HelloDao helloDao = null;
    private HelloDao2 helloDao2 = null;
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    {
        ctx = new ClassPathXmlApplicationContext("dbContext.xml");
        jdbcTemplate = (JdbcTemplate)ctx.getBean("jdbcTemplate");
        helloDao = ctx.getBean(HelloDao.class);
        helloDao2 = ctx.getBean(HelloDao2.class);
        namedParameterJdbcTemplate = ctx.getBean(NamedParameterJdbcTemplate.class);
    }

    /*
     * 使用具名参数时，可以使用update(String sql, SqlParameterSource paramSource)方法进行更新操作
     * 1.SQL语句中的参数名和类的属性一致
     * 2.使用SqlParameterSource的BeanPropertySqlParameterSource实现类作为参数。
     */
    @Test
    public void testNamedParameterJdbcTemplate2(){
        String sql = "INSERT INTO hello(id, name, sex) values(:id, :name, :sex)";

        Hello hello = new Hello();
        hello.setId(7);
        hello.setName("King");
        hello.setSex(2);
        SqlParameterSource parameterSource = new BeanPropertySqlParameterSource(hello);
        namedParameterJdbcTemplate.update(sql,parameterSource);
    }

    /*
     * 可以为参数起名字
     * 1.好处：若有多个参数，则不用再去对应配置，直接对应参数名，便于维护
     * 2.缺点：较为麻烦
     */
    @Test
    public void testNamedParameterJdbcTemplate(){
        String sql = "INSERT INTO hello(id, name, sex) values(:id, :name, :sex)";
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("id", 6);
        paramMap.put("name", "Lily");
        paramMap.put("sex", 1);

        namedParameterJdbcTemplate.update(sql, paramMap);
    }

    @Test
    public void testHelloDao2(){
        System.out.println(helloDao2.get(2));
    }

    @Test
    public void testHelloDao(){
        System.out.println(helloDao.get(1));
    }

    /*
     * 获取单个列的值，或做统计查询
     * 使用queryForObject(String sql, Class<T> requiredType)方法
     */
    @Test
    public void testQueryForObject2(){
        String sql = "SELECT count(id) from hello";
        long count = jdbcTemplate.queryForObject(sql, Long.class);
        System.out.println(count);
    }

    /*
     * 查到实体类的集合
     * 注意调用的不是queryForList方法
     */
    @Test
    public void testQueryForList(){
        String sql = "SELECT id, name, sex FROM hello where id > ?";
        RowMapper<Hello> rowMapper = new BeanPropertyRowMapper<>(Hello.class);
        List<Hello> hellos = jdbcTemplate.query(sql, rowMapper, 2);
        System.out.println(hellos);
    }

    /*
     * 从数据库中获取一条记录，实际得到一个对象
     * 注意不是调用queryForObject(String sql, Class<T> requiredType, Object... args)方法
     * 而需要调用queryForObject(String sql, RowMapper<T> rowMapper, Object... args)
     * 1.其中的RowMapper指定如何去映射结果集的行，常用的实现类为BeanPropertyRowMapper
     * 2.使用SQL中列的别名完成列名和类的属性名的映射。
     * 3.不支持级联属性，JdbcTemplate到底是一个JDBC的小工具，而不是ORM框架
     */
    @Test
    public void testQueryForObject(){
        String sql = "SELECT id, name, sex FROM hello where id = ?";
        RowMapper<Hello> rowMapper = new BeanPropertyRowMapper<>(Hello.class);
        Hello hello = jdbcTemplate.queryForObject(sql, rowMapper, 1);
        System.out.println(hello);
    }

    /*
     * 执行批量更新：批量INSERT、UPDATE、DELETE
     * 最后一个参数是Object[]的List类型：因为修改一条记录需要一个Object的数组，多条就需要多个Object的数组
     */
    @Test
    public void testBatchUpdate(){
        String sql = "INSERT INTO hello(id, name, sex) VALUES(?, ?, ?)";
        List<Object[]> batchArgs = new ArrayList<>();
        batchArgs.add(new Object[]{3, "Rose", 1});
        batchArgs.add(new Object[]{4, "Jack", 1});
        batchArgs.add(new Object[]{5, "Lucy", 1});
        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    /*
     * 执行INSERT、UPDATE、DELETE
     */
    @Test
    public void testUpdate(){
        String sql = "UPDATE hello SET sex = ? where id = ?";
        jdbcTemplate.update(sql, 1, 1);
    }

    @Test
    public void testDataSource() throws SQLException {
        DataSource dataSource = ctx.getBean(DataSource.class);
        System.out.println(dataSource.getConnection());
    }
}
