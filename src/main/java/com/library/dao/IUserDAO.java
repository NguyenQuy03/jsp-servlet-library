package com.library.dao;

import com.library.model.UserModel;

public interface IUserDAO{
	UserModel findByUserNameAndPassWordAndStatus(String userName, String password, Boolean status);
}
