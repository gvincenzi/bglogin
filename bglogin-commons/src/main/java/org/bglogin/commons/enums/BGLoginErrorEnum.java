package org.bglogin.commons.enums;

/**
 * Error messages enumeration
 * @author Giuseppe Vincenzi
 *
 */
public enum BGLoginErrorEnum {
	LOGIN_ERROR("login.error");
	
	/**
	 * Key message used by Spring MVC
	 */
	private String key;
	
	/**
	 * Constructor
	 * @param key String
	 */
	private BGLoginErrorEnum(String key) {
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
