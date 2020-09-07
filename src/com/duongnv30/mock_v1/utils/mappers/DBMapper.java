package com.duongnv30.mock_v1.utils.mappers;

import java.sql.ResultSet;

//Hỗ trợ việc Map các record trong Database sang Object trên application
public interface DBMapper<T> {
	T mapRow(ResultSet rs);
}
