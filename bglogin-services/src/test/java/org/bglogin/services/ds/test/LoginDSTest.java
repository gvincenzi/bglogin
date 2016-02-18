package org.bglogin.services.ds.test;

import java.util.List;

import org.bglogin.commons.exceptions.BGLoginGenericException;
import org.bglogin.model.dao.IUserDao;
import org.bglogin.model.entity.User;
import org.bglogin.services.config.test.TestServicesConfig;
import org.bglogin.services.ds.ILoginDS;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * JUnit Test of Service for login
 * 
 * @author Giuseppe Vincenzi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = TestServicesConfig.class)
@ActiveProfiles("test")
public class LoginDSTest {
	@Autowired
	private ILoginDS loginDS;

	@Autowired
	private IUserDao userDao;

	@Test(expected = BGLoginGenericException.class)
	public void testLoginFailed1() throws BGLoginGenericException {
		List<User> users = userDao.getAllUsers();
		Assert.assertNotNull(users);

		if (!users.isEmpty()) {
			User user = users.get(0);
			Assert.assertNotNull(user);
			loginDS.login(user.getUsername(), "");
		}
	}

	@Test(expected = BGLoginGenericException.class)
	public void testLoginFailed2() throws BGLoginGenericException {
		loginDS.login("", "");
	}

	@Test
	public void testLogin() throws BGLoginGenericException {
		List<User> users = userDao.getAllUsers();
		Assert.assertNotNull(users);

		for (User user : users) {
			User loggedUser = loginDS.login(user.getUsername(), user.getPassword());
			Assert.assertNotNull(user);
			Assert.assertEquals(user.getUserId(), loggedUser.getUserId());
		}
	}

}
