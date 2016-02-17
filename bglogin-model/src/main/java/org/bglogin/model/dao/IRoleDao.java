package org.bglogin.model.dao;

import java.util.List;

import org.bglogin.model.entity.Role;

/**
 * Interface DAO Service for entity Role
 * @author Giuseppe Vincenzi
 *
 */
public interface IRoleDao {
	/**
	 * Method to find an Role by its ID
	 * @param roleId int
	 * @return Role
	 */
	public Role getRoleById(int roleId);
	
	/**
	 * Method to get a list of all Roles in db
	 * @return List<Role>
	 */
	public List<Role> getAllRoles();
}
