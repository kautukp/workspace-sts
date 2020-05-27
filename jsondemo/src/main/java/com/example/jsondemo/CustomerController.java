/**
 * 
 */
package com.example.jsondemo;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.example.jsondemo.dao.CustomerOperationsDAO;
import com.example.jsondemo.model.Customer;
import com.example.jsondemo.model.Customers;

/**
 * @author USER
 *
 */
@RestController
@RequestMapping(path = "/customers")
public class CustomerController {

	@Autowired
	private CustomerOperationsDAO customerOperationsDAO;

	/**
	 * 
	 */
	@GetMapping(path = "/get-all-cust", produces = { "application/json" })
	public Customers getAllCustomers() {
		return customerOperationsDAO.getAllCustomers();
	}

	/**
	 * 
	 */
	@PostMapping(path = "/add-cust", consumes = { "application/json" }, produces = { "application/json" })
	public ResponseEntity<Object> addCustomer(@RequestBody Customer customer) {
		Integer custID = customerOperationsDAO.getAllCustomers().getCustomerList().size() + 1;
		customer.setCustomerID(custID);
		customerOperationsDAO.addCustomer(customer);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(customer.getCustomerID()).toUri();

		return ResponseEntity.created(location).build();
	}

}
