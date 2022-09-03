package com.library.dao;

import java.util.List;

import com.library.model.CategoryModel;

public interface ICategoryDAO extends IAbstractDAO<CategoryModel> {
	List<CategoryModel> findAll();
	CategoryModel findOneById(long id);
	CategoryModel findOneByCode(String code);
}
