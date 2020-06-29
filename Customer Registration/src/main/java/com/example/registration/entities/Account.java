/**
 * 
 */
package com.example.registration.entities;

import java.math.BigDecimal;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

/**
 * @author User
 *
 */
@Data
@Entity
@Table(name = "ACCOUNT")
public class Account {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ACC_ID")
	private long acc_id;

	@Column(name = "ACC_TYPE")
	private String accType;

	@Column(name = "BALANCE")
	private BigDecimal balance;

	@Column(name = "IS_JOINT_ACCOUNT")
	private Boolean isJointAccount;

	@JsonIgnore
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "cust_id", nullable = false)
	private Customer customer;

}
