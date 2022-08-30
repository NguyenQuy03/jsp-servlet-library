package com.library.dao.impl;

import java.util.List;

import com.library.dao.ICategoryDAO;
import com.library.mapper.CategoryMapper;
import com.library.model.CategoryModel;

public class CategoryDAO extends AbstractDAO<CategoryModel> implements ICategoryDAO {
	
	@Override
	public List<CategoryModel> findAll() {
		String sql = "SELECT * FROM category";
		return query(sql, new CategoryMapper());
	}
	
}
