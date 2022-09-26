package com.library.dao;

import java.util.List;

import com.library.model.BookModel;
import com.library.model.UserModel;
import com.library.paging.Pageable;

public interface IBookDAO extends IAbstractDAO<BookModel> {
	int getTotalItem();
	int getTotalItemByPublisherName(String createdBy);
	int getTotalItemByCategoryId(Long categoryId);
	
	BookModel findOne(Long id);
	List<BookModel> findAllByCategoryId(Long categoryId, Pageable pageable);
	List<BookModel> findAll(Pageable pageable);
	List<BookModel> findAllByPublisherName(Pageable pageable, UserModel userModel);
	
	Long save(BookModel bookModel);
	void update(BookModel updatedBook);
	void delete(long id);
}
