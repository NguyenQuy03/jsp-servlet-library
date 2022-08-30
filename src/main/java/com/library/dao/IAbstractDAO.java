package com.library.dao;

import java.util.List;

import com.library.mapper.IRowMapper;

public interface IAbstractDAO<E> {
	@SuppressWarnings("hiding")
	<E> List<E> query(String sql, IRowMapper<E> rowMapper, Object... parameters);
	void update(String sql, Object... parameters);
	Long insert(String sql, Object... parameters);
	int count(String sql, Object... parameters);
}
