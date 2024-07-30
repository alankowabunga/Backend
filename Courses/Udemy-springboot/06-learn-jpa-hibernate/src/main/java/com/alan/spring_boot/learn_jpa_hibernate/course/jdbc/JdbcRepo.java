package com.alan.spring_boot.learn_jpa_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

/*Spring JDBC
Step one:

private Course course;
1. set as repository
2. JdbcTemplate tool
3. use CommandLineRunner to insert data when initialize project

Step two:
1. create the table class and define each column's info
2. make jdbcTemplate's crud method more flexible
3. adjust jdbcCommandLineRunner to new added class 'course'

Step three:
1. create select query
2. use queryForObject + BeanPropertyRowMapper

* */
@Repository
public class JdbcRepo {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private static String INSERT_QUERY =
    """
        INSERT INTO COURSE(ID,NAME,AUTHOR) VALUES(?,?,?);
    """;
    private static String DELETE_QUERY =
    """
         DELETE FROM COURSE WHERE id = ?;
    """;
    private static String SELECT_QUERY =
    """
         SELECT * FROM COURSE WHERE id = ?;
    """;

    public void insert(Course course){
        jdbcTemplate.update(INSERT_QUERY,course.getId(),course.getName(),course.getAuthor());
    }

    public void deleteById(long id){
        jdbcTemplate.update(DELETE_QUERY,id);
    }

    public Course findById(long id){
        // class Course 需要有 SETTER
        return jdbcTemplate.queryForObject(SELECT_QUERY,new BeanPropertyRowMapper<>(Course.class),id);
    }
}
