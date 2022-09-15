package com.library.service;

import java.util.List;

import com.library.model.BookModel;
import com.library.model.RoleModel;
import com.library.paging.Pageable;

public interface IBookService {
	List<BookModel> findByCategoryId(Long cateforyId);
	List<BookModel> findAll(Pageable pageable);
	List<BookModel> findAllByRole(Pageable pageable, RoleModel roleModel);

	BookModel findOne(long id);
	int getTotalItem();
	int getTotalItemByRole(String createdBy);
	
	BookModel save(BookModel bookModel);
	BookModel update(BookModel updatedBook);
	void delete(long[] ids);
}
