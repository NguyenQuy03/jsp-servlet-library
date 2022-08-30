package com.library.dao.impl;

import java.util.List;

import com.library.dao.IBookDAO;
import com.library.mapper.BookMapper;
import com.library.model.BookModel;
import com.library.paging.Pageable;

public class BookDAO extends AbstractDAO<BookModel> implements IBookDAO {

	@Override
	public List<BookModel> findByCategoryId(Long categoryId) {
		String sql = "SELECT * FROM book WHERE categoryId = ?";
		
		return query(sql, new BookMapper(), categoryId);
	}

	@Override
	public List<BookModel> findAll(Pageable pageable) {
		StringBuilder sql = new StringBuilder("SELECT * FROM book");
		if (pageable.getSorter().getSortName() != null && pageable.getSorter().getSortBy() != null) {
			sql.append(" ORDER BY " + pageable.getSorter().getSortName() + " " +pageable.getSorter().getSortBy());
		}
		if (pageable.getLimit() != null && pageable.getOffset() != null) {
			sql.append(" LIMIT " + pageable.getLimit() + " OFFSET " + pageable.getOffset());
		}
		return query(sql.toString(), new BookMapper());
	}

	@Override
	public Long insert(BookModel bookModel) {
		StringBuilder sql= new StringBuilder("INSERT INTO book (title, thumbnail");
		sql.append(", shortDescription, author, categoryId, linkDownload)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?);");
		return insert(sql.toString(), bookModel.getTitle(), bookModel.getThumbnail(),
				bookModel.getShortDescription(), bookModel.getAuthor(), bookModel.getCategoryId(),
				bookModel.getLinkDownload());
	}

	@Override
	public void update(BookModel updatedBook) {
		StringBuilder sql = new StringBuilder("UPDATE book SET title = ?, thumbnail = ?,");
		sql.append(" shortDescription = ?, author = ?, categoryId = ?,");
		sql.append(" linkDownload = ? WHERE id = ?");
		
		update(sql.toString(), updatedBook.getTitle(), updatedBook.getThumbnail(), updatedBook.getShortDescription(),
				updatedBook.getAuthor(), updatedBook.getCategoryId()
				);
		
	}

	@Override
	public void delete(long id) {
		String sql = "DELETE from book WHERE id = ?";
		
		update(sql, id);
	}

	@Override
	public int getTotalItem() {
		String sql = "SELECT count(*) FROM book";
		return count(sql);
	}

	@Override
	public List<BookModel> findAllByAuthor() {
		String sql = "SELECT * FROM book WHERE author = ?";
		
		return query(sql, new BookMapper());	
	}

}