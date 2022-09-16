package com.library.service.impl;

import javax.inject.Inject;

import com.library.dao.IUserDAO;
import com.library.model.UserModel;
import com.library.service.IUserService;

public class UserService implements IUserService {
	
	@Inject
	private IUserDAO userDAO;

	@Override
	public UserModel findByUserNameAndPassWordAndStatus(String userName, String password, Boolean status) {
		return userDAO.findByUserNameAndPassWordAndStatus(userName, password, status);
	}

	@Override
	public UserModel findByUserName(String userName) {
		return userDAO.findByUserName(userName);
	}

}
