package com.library.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import com.library.dao.IAbstractDAO;
import com.library.mapper.IRowMapper;

public class AbstractDAO<E> implements IAbstractDAO<E> {
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("db");

	public Connection getConnection() {
		try {
			Class.forName(resourceBundle.getString("driverName"));
			String url = resourceBundle.getString("url");
			String user = resourceBundle.getString("user");
			String password = resourceBundle.getString("password");
			return DriverManager.getConnection(url, user, password);
		} catch (SQLException | ClassNotFoundException e) {
			return null;
		}
	}

	private void setPatameter(PreparedStatement statement, Object... parameters) {
		for(int i = 0; i < parameters.length; i++) {
			Object parameter = parameters[i];
			int index = i + 1;
			try {
				if (parameter instanceof String) {
					statement.setString(index, (String) parameter);
				} else if (parameter instanceof Long) {
					statement.setLong(index, (Long) parameter);
				} else if (parameter instanceof Boolean) {
					statement.setBoolean(index, (Boolean) parameter);
				} else if (parameter instanceof Timestamp) {
					statement.setTimestamp(index, (Timestamp) parameter);
				} else if (parameter instanceof Integer) {
					statement.setInt(index, (Integer) parameter);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}	
		}
	}

	@SuppressWarnings("hiding")
	@Override
	public <E> List<E> query(String sql, IRowMapper<E> rowMapper, Object... parameters) {
		List<E> result = new ArrayList<>();
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		
		try {
			connection = getConnection(); 
			statement = connection.prepareStatement(sql);
			setPatameter(statement, parameters);
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				result.add(rowMapper.mapRow(resultSet));	
			}
			return result;
		} catch (Exception e) {
			return null;
		} finally {
			try {
				if(statement != null) {
						statement.close();
				}
				if(connection != null) {
					connection.close();
				}
				if(resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e) {
				return null;
			}
		}
	}
	

	@Override
	public void update(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		
		try {
			connection = getConnection(); 
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql);
			setPatameter(statement, parameters);
			statement.executeUpdate();
			connection.commit();
			
		} catch (Exception e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}
				if(connection != null) {
					connection.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();;
			}
		}	
	}

	@Override
	public Long insert(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		Long id = null;
		
		try {
			connection = getConnection(); 
			connection.setAutoCommit(false);
			statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			setPatameter(statement, parameters);
			statement.executeUpdate();
			
			resultSet = statement.getGeneratedKeys();
			while(resultSet.next()) {
				id = resultSet.getLong("id");
			}
			connection.commit();
			
			return id;
		} catch (Exception e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
			return id;
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}
				if(connection != null) {
					connection.close();
				} if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}	
	}

	@Override
	public int count(String sql, Object... parameters) {
		Connection connection = null;
		PreparedStatement statement = null;
		ResultSet resultSet = null;
		int count = 0;
		
		try {
			connection = getConnection(); 
			statement = connection.prepareStatement(sql);
			setPatameter(statement, parameters);
			
			resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				count = resultSet.getInt(1);
			}
			
			return count;
		} catch (Exception e1) {
			e1.printStackTrace();

			return count;
		} finally {
			try {
				if(statement != null) {
					statement.close();
				}
				if(connection != null) {
					connection.close();
				} if (resultSet != null) {
					resultSet.close();
				}
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}
