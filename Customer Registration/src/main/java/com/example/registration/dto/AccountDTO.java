/**
 * 
 */
package com.example.registration.dto;

import java.io.Serializable;
import java.math.BigDecimal;

import com.example.registration.entities.Customer;

import lombok.Data;

/**
 * @author User
 *
 */
@SuppressWarnings("serial")
@Data
public class AccountDTO implements Serializable {
	private String accType;

	private BigDecimal balance;

	private Boolean isJointAccount;

	private Customer customer;
}
