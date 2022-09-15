package com.library.dao;

import java.util.List;

import com.library.model.BookModel;
import com.library.model.RoleModel;
import com.library.paging.Pageable;

public interface IBookDAO extends IAbstractDAO<BookModel> {
	List<BookModel> findByCategoryId(Long categoryId);
	BookModel findOne(Long id);
	
	List<BookModel> findAll(Pageable pageable);
	int getTotalItem();
	int getTotalItemByRole(String createdBy);
	List<BookModel> findAllByRole(Pageable pageable, RoleModel roleModel);
	
	Long save(BookModel bookModel);
	void update(BookModel updatedBook);
	void delete(long id);
}
