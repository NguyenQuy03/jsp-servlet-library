package com.library.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.library.dao.IBookDAO;
import com.library.dao.ICategoryDAO;
import com.library.model.BookModel;
import com.library.model.CategoryModel;
import com.library.model.RoleModel;
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
	public BookModel save(BookModel bookModel) {
		bookModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		
		CategoryModel categoryModel = categoryDAO.findOneByCode(bookModel.getCategoryCode());
		bookModel.setCategoryId(categoryModel.getId());
		Long bookId = bookDAO.save(bookModel);
		
		return bookDAO.findOne(bookId);
	}

	@Override
	public BookModel update(BookModel updatedBook) {
		BookModel preBook = bookDAO.findOne(updatedBook.getId());
		CategoryModel categoryModel = categoryDAO.findOneByCode(updatedBook.getCategoryCode());
		
		updatedBook.setCreatedDate(preBook.getCreatedDate());
		updatedBook.setCreatedBy(preBook.getCreatedBy());
		updatedBook.setModifiedDate(new Timestamp(System.currentTimeMillis()));
		updatedBook.setCategoryId(categoryModel.getId());
		
		bookDAO.update(updatedBook);
		return bookDAO.findOne(updatedBook.getId());
	}

	@Override
	public BookModel findOne(long id) {
		BookModel bookModel = bookDAO.findOne(id);
		CategoryModel categoryModel = categoryDAO.findOneById(bookModel.getCategoryId());
		bookModel.setCategoryCode(categoryModel.getCode());
		return bookModel;
	}

	@Override
	public List<BookModel> findAllByRole(Pageable pageable, RoleModel roleModel) {
		return bookDAO.findAllByRole(pageable, roleModel);
	}

	@Override
	public int getTotalItemByRole(String createdBy) {
		return bookDAO.getTotalItemByRole(createdBy);
	}

}
