package com.library.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.model.BookModel;

public class BookMapper implements IRowMapper<BookModel> {

	@Override
	public BookModel mapRow(ResultSet rs) {
		BookModel book = new BookModel();
		try {
			book.setId(rs.getInt("id"));
			book.setTitle(rs.getString("title"));
			book.setThumbnail(rs.getString("thumbnail"));
			book.setShortDescription(rs.getString("shortDescription"));
			book.setCategoryId(rs.getLong("categoryId"));
			book.setLinkDownload(rs.getString("linkDownload"));
			book.setAuthor(rs.getString("author"));
			book.setCreatedDate(rs.getTimestamp("createdDate"));
			book.setCreatedBy(rs.getString("createdBy"));
			if (rs.getTimestamp("modifiedDate") != null) {
				book.setModifiedDate(rs.getTimestamp("modifiedDate"));
			}
			if (rs.getString("modifiedBy") != null) {
				book.setModifiedBy(rs.getString("modifiedBy"));
			}

		} catch (SQLException e) {
			return null;
		}

		return book;
	}
	
}
