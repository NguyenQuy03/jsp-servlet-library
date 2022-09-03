package com.library.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.library.dao.IBookDAO;
import com.library.dao.ICategoryDAO;
import com.library.model.BookModel;
import com.library.model.CategoryModel;
import com.library.paging.Pageable;
import com.library.service.IBookService;

public class BookService implements IBookService {
	
	@Inject
	private IBookDAO bookDAO;
	
	@Inject
	private ICategoryDAO categoryDAO;

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

	@Override
	public void delete(long[] ids) {
		for (long id : ids) {
			bookDAO.delete(id);
		}
	}

	@Override
	public BookModel insert(BookModel bookModel) {
		bookModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		
		CategoryModel categoryModel = categoryDAO.findOneByCode(bookModel.getCategoryCode());
		bookModel.setCategoryId(categoryModel.getId());
		Long bookId = bookDAO.insert(bookModel);
		
		return bookDAO.findOne(bookId);
	}

	@Override
	public BookModel update(BookModel updatedBook) {
		BookModel preBook = bookDAO.findOne(updatedBook.getId());
		CategoryModel categoryModel = categoryDAO.findOneByCode(updatedBook.getCategoryCode());
		
		preBook.setCategoryId(categoryModel.getId());
		updatedBook.setCreatedDate(preBook.getCreatedDate());
		updatedBook.setCreatedBy(preBook.getCreatedBy());
		updatedBook.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		
		bookDAO.update(updatedBook);
		return bookDAO.findOne(updatedBook.getId());
	}

}
