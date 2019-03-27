package com.adeng.patterns.behavioral.template;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * 解析 SQL 行数据
 *
 * @param <T>
 */
public interface RowMapper<T> {

    public T mapRow(ResultSet rs, int rowNum) throws SQLException;
}
