package org.bglogin.web.enums;

/**
 * Login page message keys enumeration
 * @author Giuseppe Vincenzi
 *
 */
public enum LoginMessageKeyEnum {
	LOGIN_USER_OK("login.user.ok"),
	LOGIN_ADMIN_OK("login.admin.ok"),
	LOGIN_LOGOUT_OK("login.logout.ok");
	
	/**
	 * Key message used by Spring MVC
	 */
	private String key;
	
	/**
	 * Constructor
	 * @param key String
	 */
	private LoginMessageKeyEnum(String key) {
		this.setKey(key);
	}

	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}

	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
}
