/**
 * 
 */
package com.example.jsondemo.dao;

import com.example.jsondemo.model.Customer;
import com.example.jsondemo.model.Customers;

/**
 * @author USER
 *
 */
public interface CustomerOperations {

	public void addCustomer(Customer customer);

	public Customers getAllCustomers();

}
