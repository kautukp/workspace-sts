/**
 * 
 */
package com.example.registration.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.registration.dto.CustomerDTO;
import com.example.registration.entities.Customer;
import com.example.registration.exception.CustomerException;
import com.example.registration.service.CustomerService;
import com.example.registration.utils.RegistrationUtils;

/**
 * @author User
 *
 */
@RestController(RegistrationUtils.REGISTRATION_URI)
public class CustomerEndPointController {

	@Autowired
	CustomerService customerService;

	/**
	 * 
	 * @param customer
	 * @return
	 * @throws CustomerException
	 */
	@PostMapping(RegistrationUtils.CREATE_CUSTOMER_URI)
	public ResponseEntity<CustomerDTO> createCustomer(@RequestBody Customer customer) throws CustomerException {
		CustomerDTO customerDTO = customerService.createCustomer(customer);
		return new ResponseEntity<>(customerDTO, HttpStatus.CREATED);
	}

	/**
	 * 
	 * @param cust_id
	 * @return
	 * @throws CustomerException
	 */
	@GetMapping(RegistrationUtils.FIND_CUSTOMER_BY_ID_URI)
	public ResponseEntity<CustomerDTO> findCustomerByID(@PathVariable("cust_id") Long cust_id)
			throws CustomerException {
		CustomerDTO customerDTO = customerService.findCustomerByID(cust_id);
		return new ResponseEntity<>(customerDTO, HttpStatus.OK);
	}

	/**
	 * 
	 * @return
	 * @throws CustomerException
	 */
	@GetMapping(RegistrationUtils.SORT_CUSTOMERS_URI)
	public List<CustomerDTO> sortCustomerByFirstNameLastName() throws CustomerException {
		return customerService.findCustomerSortByFirstNameLastName();
	}

	/**
	 * 
	 * @param parameterMap of type Map
	 * @return
	 * @throws CustomerException
	 */
	@PutMapping(RegistrationUtils.UPDATE_CUSTOMER_PHONE_URI)
	public ResponseEntity<CustomerDTO> updateCustomerPhoneByID(@RequestParam Map<String, String> parameterMap)
			throws CustomerException {
		Long cust_id = Long.parseLong(parameterMap.get("cust_id"));
		Long newPhone = Long.parseLong(parameterMap.get("phone"));

		CustomerDTO customerDTO = customerService.updateCustomerPhoneByID(cust_id, newPhone);
		return new ResponseEntity<>(customerDTO, HttpStatus.ACCEPTED);
	}

	/**
	 * 
	 * @param cust_id
	 * @return
	 * @throws CustomerException
	 */
	@DeleteMapping(RegistrationUtils.DELETE_CUSTOMER_BY_ID_URI)
	public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable("cust_id") Long cust_id) throws CustomerException {
		CustomerDTO customerDTO = customerService.deleteCustomerByID(cust_id);
		return new ResponseEntity<>(customerDTO, HttpStatus.OK);
	}

}
