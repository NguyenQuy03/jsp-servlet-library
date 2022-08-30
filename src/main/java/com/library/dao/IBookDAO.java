package com.library.dao;

import java.util.List;

import com.library.model.BookModel;
import com.library.paging.Pageable;

public interface IBookDAO extends IAbstractDAO<BookModel> {
	List<BookModel> findByCategoryId(Long categoryId);
	List<BookModel> findAll(Pageable pageable);
	List<BookModel> findAllByAuthor();
	Long insert(BookModel bookModel);
	void update(BookModel updatedBook);
	void delete(long id);
	int getTotalItem();
}
