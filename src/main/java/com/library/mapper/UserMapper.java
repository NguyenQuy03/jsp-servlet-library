package com.library.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.model.RoleModel;
import com.library.model.UserModel;

public class UserMapper implements IRowMapper<UserModel> {
	@Override
	public UserModel mapRow(ResultSet rs) {
		try {
			UserModel userModel = new UserModel();
			userModel.setId(rs.getLong("id"));
			userModel.setUserName(rs.getString("userName"));
			userModel.setFullName(rs.getString("fullName"));
			userModel.setPassword(rs.getString("password"));
			userModel.setStatus(rs.getBoolean("status"));
			userModel.setRoleId(rs.getLong("roleId"));
			
			try {
				RoleModel roleModel = new RoleModel();
				roleModel.setName(rs.getString("name"));
				roleModel.setCode(rs.getString("code"));
				userModel.setRoleModel(roleModel);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
			
			return userModel;
		} catch (SQLException e) {
			return null;
		}
	}

}
