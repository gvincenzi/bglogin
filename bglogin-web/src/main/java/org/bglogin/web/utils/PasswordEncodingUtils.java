package org.bglogin.web.utils;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * PasswordEncodingUtils
 * @author Giuseppe Vincenzi
 *
 */
public class PasswordEncodingUtils {
	/**
	 * Method to encode a password
	 * @param password
	 * @return
	 */
	public static String encodingPassword(String password){
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder.encode(password);
	}
}
