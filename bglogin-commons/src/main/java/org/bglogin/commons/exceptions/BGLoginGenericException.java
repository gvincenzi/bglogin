package org.bglogin.commons.exceptions;

import org.bglogin.commons.enums.BGLoginErrorEnum;

/**
 * Generic exception class
 * @author Giuseppe Vincenzi
 *
 */
public class BGLoginGenericException extends Exception {
	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 905890266458746997L;
	
	/**
	 * BGLoginErrorEnum
	 */
	private BGLoginErrorEnum error;
	
	/**
	 * Constructor
	 * @param error BGLoginErrorEnum
	 */
	public BGLoginGenericException(BGLoginErrorEnum error) {
		super(error.name());
		this.error=error;
	}
	
	/**
	 * Constructor
	 * @param error BGLoginErrorEnum
	 * @param messageToLog String
	 */
	public BGLoginGenericException(BGLoginErrorEnum error, String messageToLog) {
		super(messageToLog);
		this.error=error;
	}

	/**
	 * @return the error
	 */
	public BGLoginErrorEnum getError() {
		return error;
	}

	/**
	 * @param error the error to set
	 */
	public void setError(BGLoginErrorEnum error) {
		this.error = error;
	}
}
