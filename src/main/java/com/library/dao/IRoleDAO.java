package com.library.dao;

import com.library.model.RoleModel;

public interface IRoleDAO extends IAbstractDAO<RoleModel> {
	RoleModel findOneById(long id);
}
