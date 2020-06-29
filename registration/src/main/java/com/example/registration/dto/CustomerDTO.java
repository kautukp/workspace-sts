/**
 * 
 */
package com.example.registration.dto;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.lang.Nullable;

import lombok.Data;

/**
 * @author User
 *
 */
@SuppressWarnings("serial")
@Data
public class CustomerDTO implements Serializable {
	
	private String firstName;

	@Nullable
    @Size(min=0, max=10, message="Length of the phone number is invaild")
	private String lastName;

	@Min(value=10, message="Age is invalid")
    @Max(value=120, message="Age is invalid")
	private Integer age;

	@Nullable
    @Size(min=0, max=10, message="Length of the phone number is invaild")
	private Long phone;

	private Boolean isActive;
	
	@Valid
    @Size(min=0, max=10, message="Account is invaild")
	private List<AccountDTO> accounts;
	
	@Valid
    @Size(min=0, max=10, message="Address is invaild")
	private List<AddressDTO> address;
}
