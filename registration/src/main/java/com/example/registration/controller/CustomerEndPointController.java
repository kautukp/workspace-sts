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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.registration.dto.CustomerDTO;
import com.example.registration.exception.CustomerException;
import com.example.registration.service.CustomerService;

/**
 * @author User
 *
 */
@RestController("/registration")
public class CustomerEndPointController {

	@Autowired
	CustomerService customerService;

	/**
	 * 
	 * @param cust_id
	 * @return
	 * @throws CustomerException
	 */
	@GetMapping("/customer/{cust_id}")
	public ResponseEntity<CustomerDTO> findCustomerByID(@PathVariable("cust_id") Long cust_id) throws CustomerException {
		CustomerDTO customerDTO = customerService.findCustomerByID(cust_id);
		return new ResponseEntity<>(customerDTO, HttpStatus.OK);
	}

	/**
	 * 
	 * @return
	 * @throws CustomerException
	 */
	@GetMapping("/customer/sort-customers")
	public List<CustomerDTO> findCustomerSortByFirstNameLastName() throws CustomerException {
		return customerService.findCustomerSortByFirstNameLastName();
	}

	/**
	 * 
	 * @param parameterMap of type Map
	 * @return
	 * @throws CustomerException
	 */
	@PutMapping("/customer/update-phone/{cust-id}")
	public ResponseEntity<CustomerDTO> updateCustomerPhoneByID(@RequestParam Map<String, String> parameterMap) throws CustomerException {
		Long cust_id =  Long.parseLong(parameterMap.get("cust_id"));
		Long newPhone =  Long.parseLong(parameterMap.get("phone"));
		
		CustomerDTO customerDTO = customerService.updateCustomerPhoneByID(cust_id, newPhone);
		return new ResponseEntity<>(customerDTO, HttpStatus.OK);
	}

	/**
	 * 
	 * @param cust_id
	 * @return
	 * @throws CustomerException
	 */
	@DeleteMapping(value = "/customer/delete-customer/{cust_id}")
	public ResponseEntity<CustomerDTO> deleteCustomer(@PathVariable("cust_id") Long cust_id)
			throws CustomerException {
		CustomerDTO customerDTO = customerService.deleteCustomerByID(cust_id);
		return new ResponseEntity<>(customerDTO, HttpStatus.OK);
	}
	
}
