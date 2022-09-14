package com.library.dao.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;

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
		if (pageable.getSorter() != null && StringUtils.isNotBlank(pageable.getSorter().getSortName())&& StringUtils.isNotBlank(pageable.getSorter().getSortBy())) {
			sql.append(" ORDER BY " + pageable.getSorter().getSortName() + " " +pageable.getSorter().getSortBy());
		}
		if (pageable.getLimit() != null && pageable.getOffset() != null) {
			sql.append(" LIMIT " + pageable.getLimit() + " OFFSET " + pageable.getOffset());
		}
		return query(sql.toString(), new BookMapper());
	}

	@Override
	public Long save(BookModel bookModel) {
		StringBuilder sql = new StringBuilder("INSERT INTO book (title, thumbnail,");
		sql.append(" shortDescription, author, categoryId, linkDownload, createdDate, createdBy)");
		sql.append(" VALUES(?, ?, ?, ?, ?, ?, ?, ?)");
		return insert(sql.toString(), bookModel.getTitle(), bookModel.getThumbnail(),
				bookModel.getShortDescription(), bookModel.getAuthor(), bookModel.getCategoryId(),
				bookModel.getLinkDownload(), bookModel.getCreatedDate(), bookModel.getCreatedBy());

	}

	@Override
	public void update(BookModel updatedBook) {
		StringBuilder sql;
		sql = new StringBuilder("UPDATE book SET title = ?, thumbnail = ?,");
		sql.append(" shortDescription = ?, author = ?, categoryId = ?,");
		sql.append(" linkDownload = ?, createdDate = ?, createdBy = ?,");
		sql.append(" modifiedDate = ?, modifiedBy = ? WHERE id = ?");
		
		update(sql.toString(), updatedBook.getTitle(), updatedBook.getThumbnail(), updatedBook.getShortDescription(),
					updatedBook.getAuthor(), updatedBook.getCategoryId(), updatedBook.getLinkDownload(),
					updatedBook.getCreatedDate(), updatedBook.getCreatedBy(), updatedBook.getModifiedDate(),
					updatedBook.getModifiedBy(), updatedBook.getId()
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

	@Override
	public BookModel findOne(Long id) {
		String sql = "SELECT * FROM book WHERE id = ?";
		List<BookModel> books = query(sql, new BookMapper(), id);
		return books.isEmpty() ? null : books.get(0);
	}

}
