package me.hobbier.dac.impl;

import com.google.common.collect.Sets;
import me.hobbier.dac.DAOFactory;
import me.hobbier.dac.HobbierDao;
import me.hobbier.dac.helper.FieldsJsonConverter;
import me.hobbier.model.Hobby;
import me.hobbier.model.Organization;
import org.apache.log4j.Logger;
import org.postgresql.util.PGobject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.Set;

/**
 * @author arpine.grigoryan.
 */
@Repository
public class HobbierDaoImpl
		implements HobbierDao {

	private DAOFactory daoFactory;
	private Logger logger = Logger.getLogger(this.getClass());

	@Autowired
	public HobbierDaoImpl(DAOFactory daoFactory) {
		this.daoFactory = daoFactory;
	}

	@Override
	public List<Organization> loadOrganizations(String projectId) {
		String sql = daoFactory.getQuery("loadOrganizations");
		List<Organization> organizations;
		try {
			organizations = daoFactory.getReadJdbcTemplate(projectId).query(sql, new DaoHelper.OrganizationMapper());
		} catch (DataAccessException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
		return organizations;
	}

	@Override
	public Optional<Organization> getById(int organisationId, String projectId) {
		String sql = daoFactory.getQuery("loadOrganizationById");
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put("organisationId", organisationId);
		Organization organization;
		try {
			organization = daoFactory.getReadJdbcTemplate(projectId).queryForObject(sql, parameters,
					new DaoHelper.OrganizationMapper());
		} catch (EmptyResultDataAccessException e) {
			organization = null;
		} catch (DataAccessException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
		return Optional.ofNullable(organization);
	}

	@Override
	public Integer save(Organization organization, String projectId) {
		String sql;
		HashMap<String, Object> parameters = new HashMap<>();
		FieldsJsonConverter jsonConverter = new FieldsJsonConverter();
		PGobject jsonObj = new PGobject();
		jsonObj.setType("json");

		parameters.put("name", organization.getName());
		parameters.put("description", organization.getDescription());
		parameters.put("parentId", organization.getParentId());
		parameters.put("fields", jsonObj);

		Integer organizationId = organization.getId();
		try {
			if (organizationId == null) {
				sql = daoFactory.getQuery("insertOrganization");
				organizationId = daoFactory.getReadJdbcTemplate(projectId).queryForObject(sql, parameters,
						Integer.class);
			} else {
				sql = daoFactory.getQuery("updateOrganization");
				parameters.put("organisationId", organizationId);

				daoFactory.getWriteJdbcTemplate(projectId).update(sql, parameters);
			}
		} catch (DataAccessException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
		return organizationId;

	}

	@Override
	public void insertOrganizationPermissions(Integer organizationId, Set<String> grantedPermissions,
	                                          String projectId) {
		String query = daoFactory.getQuery("insertOrganizationPermissions");
		HashMap<String, Object> parameters = new HashMap<>();
		parameters.put("organizationId", organizationId);
		try {
			for (String permissionId : grantedPermissions) {
				parameters.put("permissionId", permissionId);
				daoFactory.getWriteJdbcTemplate(projectId).update(query, parameters);
			}
		} catch (DataAccessException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
	}

	@Override
	public void removeOrganizationPermissions(Integer organizationId, Set<String> removedPermissions,
	                                          String projectId) {
		String query = daoFactory.getQuery("removeOrganizationPermissions");
		HashMap<String, Object> parameters = new HashMap<>();
		StringBuilder removedIdString = new StringBuilder();
		if (removedPermissions.size() > 0) {
			removedPermissions.forEach(i -> removedIdString.append("'" + i + "'").append(","));

			String replacedQuery = query.replace("$removedPermissionIds",
					removedIdString.length() > 0 ? removedIdString.substring(0, removedIdString.length() - 1) : "");
			parameters.put("organizationId", organizationId);
			try {
				daoFactory.getWriteJdbcTemplate(projectId).update(replacedQuery, parameters);
			} catch (DataAccessException e) {
				logger.error(e.getMessage());
				throw new RuntimeException(e);
			}
		}
	}

	@Override
	public Set<Hobby> getHobbies() {
		String sql = daoFactory.getQuery("loadHobbies");
		List<Hobby> hobbies;
		try {
			hobbies = daoFactory.getReadJdbcTemplate("a").query(sql,
					new DaoHelper.PermissionIdMapper());
		} catch (DataAccessException e) {
			logger.error(e.getMessage());
			throw new RuntimeException(e);
		}
		return Sets.newHashSet(hobbies);
	}
}
