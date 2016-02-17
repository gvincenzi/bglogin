package org.bglogin.model.dao.test;

import java.util.List;

import org.bglogin.model.config.test.TestModelConfig;
import org.bglogin.model.dao.IUserDao;
import org.bglogin.model.entity.User;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * JUnit Test of DAO Service for entity User
 * 
 * @author Giuseppe Vincenzi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestModelConfig.class)
@ActiveProfiles("test")
public class UserDaoTest {
	@Autowired
    private IUserDao userDao;
	
    @Test
    public void testGetUsers() {
        List<User> users = userDao.getAllUsers();
        Assert.assertNotNull(users);

        if(!users.isEmpty()){
	        User user = userDao.getUserById(users.get(0).getUserId());
	        Assert.assertNotNull(user);
	        Assert.assertEquals(users.get(0).getUserId(), user.getUserId());
	        
	        User userByUsername = userDao.getUserByUsername(users.get(0).getUsername());
	        Assert.assertNotNull(userByUsername);
	        Assert.assertEquals(users.get(0).getUsername(), userByUsername.getUsername());
        }
    }

}
