package com.library.mapper;

import java.sql.ResultSet;

public interface IRowMapper<E> {
	E mapRow(ResultSet rs);
}
