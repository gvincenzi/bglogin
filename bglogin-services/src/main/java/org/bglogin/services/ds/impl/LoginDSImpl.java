package org.bglogin.services.ds.impl;

import org.bglogin.commons.enums.BGLoginErrorEnum;
import org.bglogin.commons.exceptions.BGLoginGenericException;
import org.bglogin.model.dao.IUserDao;
import org.bglogin.model.entity.User;
import org.bglogin.services.ds.ILoginDS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Implementation of service to login in the web application
 * @author Giuseppe Vincenzi
 *
 */
@Service
public class LoginDSImpl implements ILoginDS{
	@Autowired
	private IUserDao userDao;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public User login(String username, String password) throws BGLoginGenericException {
		if(StringUtils.isEmpty(username) || StringUtils.isEmpty(password)){
			throw new BGLoginGenericException(BGLoginErrorEnum.LOGIN_ERROR, "Username or password is null");
		}
		
		User user = userDao.getUserByUsername(username);
		if(user==null){
			throw new BGLoginGenericException(BGLoginErrorEnum.LOGIN_ERROR, "User does not exist");
		}
		
		return user;
	}

}
