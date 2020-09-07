package com.duongnv30.mock_v1.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.duongnv30.mock_v1.dao.GenericDAO;
import com.duongnv30.mock_v1.utils.constant.DatabaseConstant;
import com.duongnv30.mock_v1.utils.mappers.DBMapper;


public class AbstractDAO<T> implements GenericDAO<T>{

	@Override
	public Connection getConnection() {
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			//String url = "jdbc:sqlserver://localhost:1433;databaseName=fsoftMock;"
			//		+ "user=sa;password=123456789";
			String url = "jdbc:sqlserver://"+DatabaseConstant.DB_HOST+":"+DatabaseConstant.DB_PORT
						+";databaseName="+DatabaseConstant.DB_DATABASE_NAME+";"
						+"user="+DatabaseConstant.DB_USER+";password="+DatabaseConstant.DB_PASSWORD;
			return DriverManager.getConnection(url);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void closeConnection(PreparedStatement ps, Connection conn, ResultSet rs) {
		try {
			if(ps != null) ps.close();
			if(conn != null) conn.close();
			if(rs != null) conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * hàm thực hiện đẩy các tham số vào trong câu lệnh SQL (preparedstatement)
	 */
	public void setParameters(PreparedStatement ps,Object...parameters) {
		try {
			int n = parameters.length;
			for(int i=0; i<n; i++) {
				int index = i+1;
				if(parameters[i] instanceof Integer) {
					ps.setInt(index, (int)parameters[i]);
				}else if(parameters[i] instanceof Date) {
					ps.setDate(index, (java.sql.Date)parameters[i]);
				}else {
					ps.setString(index, (String)parameters[i]);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}	
	}

	/*
	 * Hàm chung để thực hiện các câu truy vấn lấy ra các record (các câu select ... )
	 * trả ra danh sách
	 */
	@Override
	public List<T> query(String sql, DBMapper<T> mapper, Object... parameters) {
		List<T> result = new ArrayList<>();
		PreparedStatement ps = null;
		Connection conn = null;
		ResultSet rs = null;
		conn = getConnection();
		try {
			ps = conn.prepareStatement(sql);
			setParameters(ps, parameters);
			rs = ps.executeQuery();
			while(rs.next()) {
				T t = mapper.mapRow(rs);
				result.add(t);
			}
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			closeConnection(ps, conn, rs);
		}
		return null;
	}

	/*
	 *	hàm chung để thực hiện các câu SQL thêm bản ghi (câu insert into ...)
	 *	trả ra ID của bản ghi mới thêm vào
	 */
	@Override
	public Integer insert(String sql, Object... parameters) {
		Integer id = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		conn = getConnection();
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setParameters(ps, parameters);
			ps.executeUpdate();
			rs = ps.getGeneratedKeys();
			if(rs.next()) {
				id = rs.getInt(1);
			}
			conn.commit();
			return id;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return null;
		}finally {
			closeConnection(ps, conn, rs);
		}
	}

	/*
	 * Hàm chung thực hiện các câu lệnh xóa hoặc thay đổi bản ghi (update ... hoặc delete ...)
	 * trả ra số lượng bản ghi thay bị tác động
	 */
	@Override
	public Integer removeOrUpdate(String sql, Object... parameters) {
		int count = 0;
		PreparedStatement ps = null;
		Connection conn = null;
		conn = getConnection();
		try {
			conn.setAutoCommit(false);
			ps = conn.prepareStatement(sql);
			setParameters(ps, parameters);
			count = ps.executeUpdate();
			conn.commit();
			return count;
		} catch (SQLException e) {
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
			return null;
		}finally {
			closeConnection(ps, conn, null);
		}
	}
	
	
}
