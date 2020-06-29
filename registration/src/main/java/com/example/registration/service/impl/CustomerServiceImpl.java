/**
 * 
 */
package com.example.registration.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registration.dto.CustomerDTO;
import com.example.registration.entities.Customer;
import com.example.registration.exception.AddressException;
import com.example.registration.exception.CustomerException;
import com.example.registration.repository.AddressRepository;
import com.example.registration.repository.CustomerRepository;
import com.example.registration.service.CustomerService;

/**
 * @author User
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	private static final Logger LOGGER = LogManager.getLogger(CustomerServiceImpl.class);

	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AddressRepository addressRepository;

	/**
	 * Functional Interface to map Customer to Customer DTO
	 * 
	 * @return
	 */
	private static Function<Customer, CustomerDTO> mapCustomerToCustomerDTO() {
		CustomerDTO customerDTO = new CustomerDTO();
		return customer -> {
			BeanUtils.copyProperties(customer, customerDTO);
			return customerDTO;
		};
	}

	@Override
	public CustomerDTO findCustomerByID(Long cust_id) throws CustomerException {
		return customerRepository.findById(cust_id)
				.filter(Customer::getIsActive)
				.map(mapCustomerToCustomerDTO())
				.orElseThrow(() -> new CustomerException("Customer is either not active or not found"));
	}

	@Override
	public List<CustomerDTO> findCustomerSortByFirstNameLastName() throws CustomerException {
		return customerRepository.findAll().stream()
				.map(mapCustomerToCustomerDTO())
				.sorted(Comparator.comparing(
						CustomerDTO::getFirstName)
						.thenComparing(
								Comparator.comparing(CustomerDTO::getLastName)
								)
						)
				.collect(Collectors.toList());
	}

	@Override
	public List<CustomerDTO> findCustomersAgeGreaterThan40(String city) throws CustomerException, AddressException {
		return addressRepository.findByCity(city).stream()
				.map(a -> a.getCustomer())
				.filter(c -> c.getAge() > 40)
				.map(mapCustomerToCustomerDTO())
				.collect(Collectors.toList());
	}

	@Override
	public List<CustomerDTO> findCustomersByZipCode(Long zipCode) throws CustomerException, AddressException {
		return addressRepository.findAllByZipCode(zipCode).stream()
				.map(a -> a.getCustomer())
				.map(mapCustomerToCustomerDTO())
				.sorted(Comparator.comparing(CustomerDTO::getFirstName))
				.collect(Collectors.toList());
	}

	@Override
	public CustomerDTO deleteCustomerByID(Long cust_id) throws CustomerException {
		//customerRepository.deleteById(cust_id);
		Customer activeCustomer = customerRepository.findById(cust_id)
				.filter(Customer::getIsActive)				
				.orElseThrow(() -> new CustomerException("No Active customer found"));
		
		activeCustomer.setIsActive(false);	
		customerRepository.save(activeCustomer);
		
		CustomerDTO customerDTO = new CustomerDTO();
		BeanUtils.copyProperties(activeCustomer, customerDTO);
		
		return customerDTO;
		
	}

	@Override
	public CustomerDTO updateCustomerPhoneByID(Long cust_id, Long newPhone) throws CustomerException {
		
		CustomerDTO customerDTO = new CustomerDTO();
		
		Customer activeCustomer = customerRepository.findById(cust_id)
				.filter(Customer::getIsActive)
				.orElseThrow(() -> new CustomerException("No Active customer found"));
		
		if(activeCustomer.getPhone() == null) {
			activeCustomer.setPhone(newPhone); //add new phone
			customerRepository.save(activeCustomer);
			BeanUtils.copyProperties(activeCustomer, customerDTO);
			return customerDTO;
		} else {
			throw new CustomerException("Phone number is already present");
		}
	}

}
