/**
 * 
 */
package com.example.registration.service.impl;

import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.registration.dto.CustomerDTO;
import com.example.registration.entities.Account;
import com.example.registration.entities.Address;
import com.example.registration.entities.Customer;
import com.example.registration.exception.AddressException;
import com.example.registration.exception.CustomerException;
import com.example.registration.repository.AddressRepository;
import com.example.registration.repository.CustomerRepository;
import com.example.registration.service.CustomerService;
import com.example.registration.utils.RegistrationUtils;

/**
 * @author User
 *
 */
@Service
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerRepository customerRepository;

	@Autowired
	private AddressRepository addressRepository;

	/**
	 * Functional Interface to map Customer to Customer DTO
	 * 
	 * @return CustomerDTO
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
				.orElseThrow(() -> new CustomerException(RegistrationUtils.CUSTOMER_NOT_ACTIVE_INACTIVE));
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
				.orElseThrow(() -> new CustomerException(RegistrationUtils.CUSTOMER_NOT_ACTIVE));
		
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
				.orElseThrow(() -> new CustomerException(RegistrationUtils.CUSTOMER_NOT_ACTIVE));
		
		if(activeCustomer.getPhone() == null) {
			activeCustomer.setPhone(newPhone); //add new phone
			customerRepository.save(activeCustomer);
			BeanUtils.copyProperties(activeCustomer, customerDTO);
			return customerDTO;
		} else {
			throw new CustomerException(RegistrationUtils.PHONE_NUMBER_IS_PRESENT);
		}
	}

	@Override
	public CustomerDTO createCustomer(Customer customer) throws CustomerException {
		CustomerDTO customerDTO = new CustomerDTO();
		List<Address> addressList = customer.getAddress();
		if(addressList != null) {
			addressList.forEach(address -> address.setCustomer(customer));
		}
		
		List<Account> accountList = customer.getAccounts();
		if(accountList != null) {
			accountList.forEach(account -> account.setCustomer(customer));
		}
		
		customerRepository.save(customer);
		BeanUtils.copyProperties(customer, customerDTO);
		return customerDTO;
	}

}
