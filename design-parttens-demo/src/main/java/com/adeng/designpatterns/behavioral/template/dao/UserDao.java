package com.adeng.designpatterns.behavioral.template.dao;

import com.adeng.designpatterns.behavioral.template.JdbcTemplate;
import com.adeng.designpatterns.behavioral.template.RowMapper;
import com.adeng.designpatterns.behavioral.template.entry.User;

import java.util.List;

public class UserDao {


    private final JdbcTemplate jdbcTemplate;

    public UserDao(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    /**
     * 使用自定义的JDBC只需要自己根据SQL，写相应的映射即可。
     *
     * @param sql
     * @param value
     * @return
     */
    public List<User> query(String sql, Object[] value){

        return (List<User>) jdbcTemplate.executeQuery(sql, (RowMapper<User>) (rs, rowNum) -> {

            User user = new User();
            user.setUsername(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setAge(rs.getInt("age"));
            user.setAddr(rs.getString("addr"));

            return user;
        },value);
    }

}
