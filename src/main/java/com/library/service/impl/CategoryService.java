package com.library.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.library.dao.ICategoryDAO;
import com.library.model.CategoryModel;
import com.library.service.ICategoryService;

public class CategoryService implements ICategoryService {
	
	@Inject
	ICategoryDAO categoryDAO;

	@Override
	public List<CategoryModel> findAll() {
		return categoryDAO.findAll();
	}

}
