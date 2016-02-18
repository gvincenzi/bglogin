package org.bglogin.services.ds;

import org.bglogin.commons.exceptions.BGLoginGenericException;
import org.bglogin.model.entity.User;

/**
 * Interface of service to login in the web application
 * @author Giuseppe Vincenzi
 *
 */
public interface ILoginDS {
	/**
	 * Method to verify the login of an user
	 * @param username String
	 * @param password String
	 * @return User
	 */
	public User login(String username, String password) throws BGLoginGenericException;
}
