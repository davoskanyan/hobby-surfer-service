package me.hobbier.dac;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import me.hobbier.model.Hobby;
import me.hobbier.model.Organization;

/**
 * @author lilit.abrahamyan on 11/3/2016.
 */
public interface HobbierDao {

	/**
	 * Returns all organizations of given project
	 * 
	 * @param projectId
	 *            project identifier
	 * @return organizations
	 */
	List<Organization> loadOrganizations(String projectId);

	/**
	 * Returns organizations by specified id
	 * 
	 * @param organisationId
	 *            organization
	 * @param projectId
	 *            project identifier
	 * @return organization
	 */
	Optional<Organization> getById(int organisationId, String projectId);

	/**
	 * Insert/updates organization
	 * 
	 * @param organization
	 *            organization to save
	 * @param projectId
	 *            project identifier
	 * @return id of saved organization
	 */
	Integer save(Organization organization, String projectId);

	/**
	 * Inserts organization's permissions
	 * 
	 * @param grantedPermissions
	 *            permissions specified for organization
	 * @param organizationId
	 *            organization identifier
	 * @param projectId
	 *            project identifier
	 */
	void insertOrganizationPermissions(Integer organizationId, Set<String> grantedPermissions, String projectId);

	/**
	 * Removes organization's permissions
	 * 
	 * @param organizationId
	 *            organization identifier
	 * @param removedPermissions
	 *            removed permissions
	 * @param projectId
	 *            project identifier
	 */
	void removeOrganizationPermissions(Integer organizationId, Set<String> removedPermissions, String projectId);

	/**
	 * Returns permissions granted to organization
	 *
	 * @return permissions identifiers set
	 */
	Set<Hobby> getHobbies();
}
