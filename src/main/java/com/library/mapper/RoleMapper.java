package com.library.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.library.model.RoleModel;

public class RoleMapper implements IRowMapper<RoleModel> {

	@Override
	public RoleModel mapRow(ResultSet rs) {
		try {
			RoleModel role = new RoleModel();
			role.setId(rs.getLong("id"));
			role.setName(rs.getString("name"));
			role.setCode(rs.getString("code"));
			role.setCreatedDate(rs.getTimestamp("createdDate"));
			role.setCreatedBy(rs.getString("createdBy"));
			if (rs.getTimestamp("modifieddate") != null) {
				role.setModifiedDate(rs.getTimestamp("modifieddate"));
			}
			if (rs.getString("modifiedby") != null) {
				role.setModifiedBy(rs.getString("modifiedby"));
			}
			return role;
		} catch (SQLException e) {
			return null;
		}
	}

}
