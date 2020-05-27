/**
 * 
 */
package com.example.jsondemo.model;

/**
 * @author USER
 *
 */
public class Customer {

	public long customerID;

	public String firstName;

	public String lastName;

	public String emailID;

	/**
	 * 
	 */
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(long customerID, String firstName, String lastName, String emailID) {
		super();
		this.customerID = customerID;
		this.firstName = firstName;
		this.lastName = lastName;
		this.emailID = emailID;
	}

	/**
	 * @return the customerID
	 */
	public long getCustomerID() {
		return customerID;
	}

	/**
	 * @param customerID
	 *            the customerID to set
	 */
	public void setCustomerID(long customerID) {
		this.customerID = customerID;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the emailID
	 */
	public String getEmailID() {
		return emailID;
	}

	/**
	 * @param emailID
	 *            the emailID to set
	 */
	public void setEmailID(String emailID) {
		this.emailID = emailID;
	}

	@Override
	public String toString() {
		return "Customer [id=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName + ", emailID="
				+ emailID + "]";
	}

}
