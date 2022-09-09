package com.library.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.model.BookModel;

public class BookMapper implements IRowMapper<BookModel> {

	@Override
	public BookModel mapRow(ResultSet rs) {
		try {
			BookModel book = new BookModel();
			book.setId(rs.getLong("id"));
			book.setTitle(rs.getString("title"));
			book.setThumbnail(rs.getString("thumbnail"));
			book.setShortDescription(rs.getString("shortDescription"));
			book.setCategoryId(rs.getLong("categoryId"));
			book.setLinkDownload(rs.getString("linkDownload"));
			book.setAuthor(rs.getString("author"));
			book.setCreatedDate(rs.getTimestamp("createdDate"));
			book.setCreatedBy(rs.getString("createdBy"));
			if (rs.getTimestamp("modifieddate") != null) {
				book.setModifiedDate(rs.getTimestamp("modifieddate"));
			}
			if (rs.getString("modifiedby") != null) {
				book.setModifiedBy(rs.getString("modifiedby"));
			}
			return book;
		} catch (SQLException e) {
			return null;
		}
	}
	
}
