/**
 * 
 */
package com.example.jsondemo.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author USER
 *
 */
public class Customers {

	private List<Customer> customerList;

	/**
	 * 
	 */
	public Customers() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the customerList
	 */
	public List<Customer> getCustomerList() {
		if (customerList == null) {
			customerList = new ArrayList<Customer>();
		}
		return customerList;
	}

	/**
	 * @param customerList
	 *            the customerList to set
	 */
	public void setCustomerList(List<Customer> customerList) {
		this.customerList = customerList;
	}

}
