/**
 * 
 */
package com.example.registration.utils;

/**
 * @author User
 *
 */
public class RegistrationUtils {

	/**
	 * Exception messages
	 */
	public static final String CUSTOMER_NOT_ACTIVE = "No Active customer found";
	public static final String CUSTOMER_NOT_ACTIVE_INACTIVE = "Customer is either not active or not found";
	public static final String PHONE_NUMBER_IS_PRESENT = "Phone number is already present";

	/**
	 * Controller Endpoints
	 */
	public static final String REGISTRATION_URI = "/registration";
	public static final String CREATE_CUSTOMER_URI = "/customer/create-customer";
	public static final String FIND_CUSTOMER_BY_ID_URI = "/customer/{cust_id}";
	public static final String SORT_CUSTOMERS_URI = "/customer/sort-customers";
	public static final String UPDATE_CUSTOMER_PHONE_URI = "/customer/update-phone/{cust-id}";
	public static final String DELETE_CUSTOMER_BY_ID_URI = "/customer/delete-customer/{cust_id}";
}
