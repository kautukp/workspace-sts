/**
 * 
 */
package com.example.registration.exception;

/**
 * @author User
 *
 */
@SuppressWarnings("serial")
public class AddressException extends Exception {

	/**
	 * 
	 */
	public AddressException() {
	}

	/**
	 * @param message
	 */
	public AddressException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public AddressException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public AddressException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public AddressException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
