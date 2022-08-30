package com.library.service.impl;

import java.util.List;

import javax.inject.Inject;

import com.library.dao.IBookDAO;
import com.library.model.BookModel;
import com.library.paging.Pageable;
import com.library.service.IBookService;

public class BookService implements IBookService {
	
	@Inject
	private IBookDAO bookDAO;

	@Override
	public List<BookModel> findByCategoryId(Long categoryId) {
		return bookDAO.findByCategoryId(categoryId);
	}

	@Override
	public List<BookModel> findAll(Pageable pageable) {
		return bookDAO.findAll(pageable);
	}

	@Override
	public int getTotalItem() {
		return bookDAO.getTotalItem();
	}

}
