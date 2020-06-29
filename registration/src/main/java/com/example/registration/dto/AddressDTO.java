/**
 * 
 */
package com.example.registration.dto;

import java.io.Serializable;

import com.example.registration.entities.Customer;

import lombok.Data;

/**
 * @author User
 *
 */
@SuppressWarnings("serial")
@Data
public class AddressDTO implements Serializable {

	private String city;

	private String state;

	private String country;

	private Long zipCode;

	private Customer customer;

}
