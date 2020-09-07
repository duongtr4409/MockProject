package com.duongnv30.mock_v1.dao;

import java.sql.Connection;
import java.util.List;

import com.duongnv30.mock_v1.utils.mappers.DBMapper;

public interface GenericDAO<T> {
	Connection getConnection();
	List<T> query(String sql,DBMapper<T> mapper ,Object... parameters);
	Integer insert(String sql,Object... parameters);
	Integer removeOrUpdate(String sql, Object... parameters);
}
