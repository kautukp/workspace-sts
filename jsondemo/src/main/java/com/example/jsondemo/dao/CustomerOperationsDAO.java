/**
 * 
 */
package com.example.jsondemo.dao;

import org.springframework.stereotype.Repository;

import com.example.jsondemo.model.Customer;
import com.example.jsondemo.model.Customers;

/**
 * @author USER
 *
 */
@Repository
public class CustomerOperationsDAO implements CustomerOperations {

	private static Customers customerList = new Customers();

	static {
		customerList.getCustomerList().add(new Customer(101, "Alex", "Thomas", "alex@thomas.com"));
		customerList.getCustomerList().add(new Customer(201, "David", "Miller", "david@miller.com"));
		customerList.getCustomerList().add(new Customer(301, "Virat", "Kohli", "virat@kohli.com"));
		customerList.getCustomerList().add(new Customer(100, "Sachin", "Tendulkar", "sachin@tendulkar.com"));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.example.jsondemo.dao.CustomerOperations#addCustomer(com.example.jsondemo.
	 * model.Customer)
	 */
	@Override
	public void addCustomer(Customer customer) {
		customerList.getCustomerList().add(customer);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.example.jsondemo.dao.CustomerOperations#getAllCustomers()
	 */
	@Override
	public Customers getAllCustomers() {
		return customerList;
	}

}
