package me.hobbier.dac.impl;

import me.hobbier.dac.helper.FieldsJsonConverter;
import me.hobbier.dac.helper.MultilingualStringConverter;
import me.hobbier.model.Hobby;
import me.hobbier.model.Organization;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author emil.saghatelyan on 10/31/2016.
 */
final class DaoHelper {

	static class OrganizationMapper
			implements RowMapper<Organization> {
		@Override
		public Organization mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			FieldsJsonConverter jsonConverter = new FieldsJsonConverter();
//			FieldsDto fieldsDto = new FieldsDto(jsonConverter.convertToEntityAttribute(rs.getString("Fields")));
//			return new Organization(rs.getInt("OrganizationID"), rs.getString("Name"), rs.getString("Description"),
//					(Integer) rs.getObject("ParentID"), fieldsDto, rs.getTimestamp("ModifiedOn"));
			return null;
		}
	}

	static class PermissionIdMapper
			implements RowMapper<Hobby> {
		@Override
		public Hobby mapRow(ResultSet rs, int rowNum)
				throws SQLException {
			return new Hobby(rs.getInt("id"), MultilingualStringConverter.convertToEntityAttribute(rs.getObject("name")));
		}
	}
}
