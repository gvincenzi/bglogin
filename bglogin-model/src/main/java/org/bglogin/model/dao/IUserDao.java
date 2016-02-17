package org.bglogin.model.dao;

import java.util.List;

import org.bglogin.model.entity.User;

/**
 * Interface DAO Service for entity User
 * @author Giuseppe Vincenzi
 *
 */
public interface IUserDao {
	/**
	 * Method to find an User by its ID
	 * @param userId int
	 * @return User
	 */
	public User getUserById(int userId);
	
	/**
	 * Method to find an User by its username
	 * @param username String
	 * @return User
	 */
	public User getUserByUsername(String username);
	
	/**
	 * Method to get a list of all users in db
	 * @return List<User>
	 */
	public List<User> getAllUsers();
}
