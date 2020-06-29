/**
 * 
 */
package com.example.registration.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.registration.entities.Address;
import com.example.registration.exception.AddressException;

/**
 * @author User
 *
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

	public List<Address> findAllByZipCode(Long zipCode) throws AddressException;

	public List<Address> findByCity(String city) throws AddressException;

}
