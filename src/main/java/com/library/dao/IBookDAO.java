package com.library.dao;

import java.util.List;

import com.library.model.BookModel;
import com.library.paging.Pageable;

public interface IBookDAO extends IAbstractDAO<BookModel> {
	List<BookModel> findByCategoryId(Long categoryId);
	BookModel findOne(Long id);
	
	List<BookModel> findAll(Pageable pageable);
	int getTotalItem();
	List<BookModel> findAllByAuthor();
	
	Long insert(BookModel bookModel);
	void update(BookModel updatedBook);
	void delete(long id);
}
