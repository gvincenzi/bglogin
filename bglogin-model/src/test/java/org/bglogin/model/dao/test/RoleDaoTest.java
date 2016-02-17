package org.bglogin.model.dao.test;

import java.util.List;

import org.bglogin.model.config.test.TestModelConfig;
import org.bglogin.model.dao.IRoleDao;
import org.bglogin.model.entity.Role;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * JUnit Test of DAO Service for entity Role
 * 
 * @author Giuseppe Vincenzi
 *
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=TestModelConfig.class)
@ActiveProfiles("test")
public class RoleDaoTest {
	@Autowired
    private IRoleDao roleDao;
	
    @Test
    public void testGetUsers() {
        List<Role> roles = roleDao.getAllRoles();
        Assert.assertNotNull(roles);

        if(!roles.isEmpty()){
	        Role role = roleDao.getRoleById(roles.get(0).getRoleId());
	        Assert.assertNotNull(role);
	        Assert.assertEquals(roles.get(0).getRoleId(), role.getRoleId());
        }
    }

}
