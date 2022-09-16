package com.library.dao.impl;

import java.util.List;

import com.library.dao.IUserDAO;
import com.library.mapper.UserMapper;
import com.library.model.UserModel;

public class UserDAO extends AbstractDAO<UserModel> implements IUserDAO {

	@Override
	public UserModel findByUserNameAndPassWordAndStatus(String userName, String password, Boolean status) {
		StringBuilder sql = new StringBuilder("SELECT * FROM user AS u INNER JOIN role AS r");
		sql.append(" ON u.roleId = r.id WHERE userName = ? AND password = ? AND status = ?");
		List<UserModel> users = query(sql.toString(), new UserMapper(), userName, password, status);
		return users.isEmpty() ? null : users.get(0);
		
	}

	@Override
	public UserModel findByUserName(String userName) {
		String sql = "SELECT * FROM user WHERE userName = ?";
		List<UserModel> users = query(sql, new UserMapper(), userName);
		return users.isEmpty() ? null : users.get(0);
	}

}
