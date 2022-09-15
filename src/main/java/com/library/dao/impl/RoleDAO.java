package com.library.dao.impl;

import java.util.List;

import com.library.dao.IRoleDAO;
import com.library.mapper.RoleMapper;
import com.library.model.RoleModel;

public class RoleDAO extends AbstractDAO<RoleModel> implements IRoleDAO{

	@Override
	public RoleModel findOneById(long id) {
		String sql = "SELECT * FROM role WHERE id = ?";
		List<RoleModel> roles = query(sql, new RoleMapper(), id);
		return roles.isEmpty() ? null : roles.get(0);
	}

}
