/**
 * 
 */
package com.example.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.registration.entities.Customer;

/**
 * @author User
 *
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


}
