package org.bglogin.model.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.log4j.Logger;
import org.bglogin.model.dao.IRoleDao;
import org.bglogin.model.entity.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * Implementation of DAO Service for entity Role
 * 
 * @author Giuseppe Vincenzi
 *
 */
@Repository
public class RoleDaoImpl implements IRoleDao {
	/**
	 * LOGGER
	 */
	private Logger LOGGER = Logger.getLogger(RoleDaoImpl.class);

	/**
	 * DataSource injected by Spring
	 */
	@Autowired
	private DataSource dataSource;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Role getRoleById(int roleId) {
		String sql = "SELECT * FROM role WHERE role_id = ?";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, roleId);
			Role role = null;
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				role = mapping(rs);
			}
			rs.close();
			ps.close();
			return role;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					LOGGER.error(e);
				}
			}
		}
	}

	/**
	 * Utility method to map a ResultSet in an User bean
	 * @param rs ResultSet
	 * @return User
	 * @throws SQLException exception
	 */
	private Role mapping(ResultSet rs) throws SQLException {
		Role role;
		role = new Role();
		role.setRoleId(rs.getInt("role_id"));
		role.setRole(rs.getString("role"));
		return role;
	}

	@Override
	public List<Role> getAllRoles() {
		List<Role> roles = new ArrayList<Role>();
		String sql = "SELECT * FROM role";
		Connection conn = null;
		try {
			conn = dataSource.getConnection();
			PreparedStatement ps = conn.prepareStatement(sql);
			Role role = null;
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				role = mapping(rs);
				roles.add(role);
			}
			rs.close();
			ps.close();
			return roles;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		} finally {
			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					LOGGER.error(e);
				}
			}
		}
	}
}
