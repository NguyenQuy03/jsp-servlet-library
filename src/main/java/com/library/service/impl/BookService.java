package com.library.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import com.library.dao.IBookDAO;
import com.library.dao.ICategoryDAO;
import com.library.model.BookModel;
import com.library.model.CategoryModel;
import com.library.model.UserModel;
import com.library.paging.Pageable;
import com.library.service.IBookService;

public class BookService implements IBookService {
	
	@Inject
	private IBookDAO bookDAO;
	
	@Inject
	private ICategoryDAO categoryDAO;

	@Override
	public List<BookModel> findAllByCategoryId(Long categoryId, Pageable pageable) {
		return bookDAO.findAllByCategoryId(categoryId, pageable);
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
	public List<BookModel> findAllByPublisherName(Pageable pageable, UserModel userModel) {
		return bookDAO.findAllByPublisherName(pageable, userModel);
	}

	@Override
	public int getTotalItemByPublisherName(String createdBy) {
		return bookDAO.getTotalItemByPublisherName(createdBy);
	}

	@Override
	public int getTotalItemByCategoryId(Long categoryId) {
		return bookDAO.getTotalItemByCategoryId(categoryId);
	}

}
