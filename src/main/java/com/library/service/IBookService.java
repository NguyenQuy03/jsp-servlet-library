package com.library.service;

import java.util.List;

import com.library.model.BookModel;
import com.library.model.UserModel;
import com.library.paging.Pageable;

public interface IBookService {
	int getTotalItem();
	int getTotalItemByPublisherName(String createdBy);
	int getTotalItemByCategoryId(Long categoryId);
	
	BookModel findOne(long id);
	List<BookModel> findAll(Pageable pageable);
	List<BookModel> findAllByCategoryId(Long cateforyId, Pageable pageable);
	List<BookModel> findAllByPublisherName(Pageable pageable, UserModel userModel);
	
	BookModel save(BookModel bookModel);
	BookModel update(BookModel updatedBook);
	void delete(long[] ids);
}
