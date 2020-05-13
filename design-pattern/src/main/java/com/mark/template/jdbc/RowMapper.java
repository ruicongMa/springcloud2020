package com.mark.template.jdbc;

import java.sql.ResultSet;

/**
 * @author Mark
 * @date 2020/5/13 11:30
 */
public interface RowMapper<T> {

    T mapRow(ResultSet rs, int rowNum) throws Exception;
}
