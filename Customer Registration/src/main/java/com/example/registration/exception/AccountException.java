/**
 * 
 */
package com.example.registration.exception;

/**
 * @author User
 *
 */
public class AccountException extends Exception {

	/**
	 * 
	 */
	public AccountException() {
	}

	/**
	 * @param message
	 */
	public AccountException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AccountException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AccountException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AccountException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
