/**
 * 
 */
package com.jpademo3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.jpademo3.entities.Employee;

/**
 * @author User
 *
 */
@RepositoryRestResource
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}
