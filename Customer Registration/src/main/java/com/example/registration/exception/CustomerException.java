/**
 * 
 */
package com.example.registration.exception;

/**
 * @author User
 *
 */
@SuppressWarnings("serial")
public class CustomerException extends Exception {

	/**
	 * 
	 */
	public CustomerException() {
	}

	/**
	 * @param message
	 */
	public CustomerException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public CustomerException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public CustomerException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public CustomerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
