package com.library.service;

import com.library.model.UserModel;

public interface IUserService {
	UserModel findByUserNameAndPassWordAndStatus(String userName, String password, Boolean status);
}
