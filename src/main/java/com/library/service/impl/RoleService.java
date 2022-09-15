package com.library.service.impl;

import javax.inject.Inject;

import com.library.dao.IRoleDAO;
import com.library.model.RoleModel;
import com.library.service.IRoleService;

public class RoleService implements IRoleService{
	
	@Inject
	private IRoleDAO roleDAO;

	@Override
	public RoleModel findOneById(long id) {
		return roleDAO.findOneById(id);
	}

}
