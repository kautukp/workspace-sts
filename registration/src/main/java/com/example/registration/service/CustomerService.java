/**
 * 
 */
package com.example.registration.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.registration.dto.CustomerDTO;
import com.example.registration.exception.AddressException;
import com.example.registration.exception.CustomerException;

/**
 * @author User
 *
 */
@Service
public interface CustomerService {

	/**
	 * Get customer by ID
	 * 
	 * @param cust_id
	 * @return
	 * @throws CustomerException
	 */
	public CustomerDTO findCustomerByID(Long cust_id) throws CustomerException;

	// Create customers
	/**
	 * 
	 */

	/**
	 * Get all customers - sort by firstname and then lastname
	 * 
	 * @return
	 * @throws CustomerException
	 */
	public List<CustomerDTO> findCustomerSortByFirstNameLastName() throws CustomerException;

	/**
	 * Update phone number (if not available) of a customer by ID
	 * 
	 * @param cust_id
	 * @return
	 * @throws CustomerException
	 */
	public CustomerDTO updateCustomerPhoneByID(Long cust_id, Long phone) throws CustomerException;

	/**
	 * Delete customer by ID (if present)
	 * 
	 * @param cust_id
	 * @return
	 * @throws CustomerException
	 */
	public CustomerDTO deleteCustomerByID(Long cust_id) throws CustomerException;

	/**
	 * Get customers by zipcode and display in natural order
	 * 
	 * @param zipCode
	 * @return
	 * @throws CustomerException
	 * @throws AddressException
	 */
	public List<CustomerDTO> findCustomersByZipCode(Long zipCode) throws CustomerException, AddressException;

	/**
	 * Get customers > age(40) in a particular city
	 * 
	 * @param city
	 * @return
	 * @throws CustomerException
	 */
	public List<CustomerDTO> findCustomersAgeGreaterThan40(String city) throws CustomerException, AddressException;

}
