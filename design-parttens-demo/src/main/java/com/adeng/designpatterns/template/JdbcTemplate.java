package com.adeng.designpatterns.template;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 利用模板模式 实现JdbcTemplate,
 *
 * 模板模式，将固定的流程提起出来，将少量变化的部分暴露给用户。达到简化用户操作。
 */
public class JdbcTemplate {


    private final DataSource dataSource;


    public JdbcTemplate(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    public List<?> executeQuery(String sql, RowMapper<?> rowMapper, Object[] values) {

        List<?> list = new ArrayList<>();

        /*
            利用JDK7中的 try-with-resource，自动关闭资源.
         */
        try (/* 1.建立连接 */
                Connection coon = this.getConnection();
                /* 2.利用sql建立语句集合 */
                PreparedStatement statement = this.createPreparedStatement(coon, sql)) {

            /* 3.执行语句集合，返回结果 */
            ResultSet resultSet = this.executeQuery(statement, values);

            /* 4.解析结果，如何解析？需要用户自己定义解析规则 */
            list = this.parseResultSet(resultSet, rowMapper);


        } catch (SQLException e) {
            e.printStackTrace();
        }

        /* 6.返回查询结果  */
        return list;
    }

    private ResultSet executeQuery(PreparedStatement statement, Object[] values) throws SQLException {

        int i = 0;
        for (Object o : values) {
            statement.setObject(i++, o);
        }

        return statement.executeQuery();
    }

    /**
     * 只有这里是需要用户自己实现，其他地方都是固定的。
     *
     * @param resultSet
     * @param rowMapper
     * @return
     */
    private List<?> parseResultSet(ResultSet resultSet, RowMapper<?> rowMapper) throws SQLException {

        List<Object> list = new ArrayList<>();

        int rowNum = 1;

        while (resultSet.next()) {

            list.add(rowMapper.mapRow(resultSet, rowNum++));
        }

        return list;
    }

    private PreparedStatement createPreparedStatement(Connection coon, String sql) throws SQLException {
        return coon.prepareStatement(sql);
    }

    private Connection getConnection() throws SQLException {
        return this.dataSource.getConnection();
    }
}
