package com.library.service;

import java.util.List;

import com.library.model.BookModel;
import com.library.paging.Pageable;

public interface IBookService {
	List<BookModel> findByCategoryId(Long cateforyId);
	List<BookModel> findAll(Pageable pageable);
	int getTotalItem();
}
