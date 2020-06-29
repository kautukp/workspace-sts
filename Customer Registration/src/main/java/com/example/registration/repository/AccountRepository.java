/**
 * 
 */
package com.example.registration.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.registration.entities.Account;

/**
 * @author User
 *
 */
@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

}
