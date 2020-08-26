/**
 * 
 */
package com.jpademo3.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jpademo3.entities.Department;

/**
 * @author User
 *
 */
@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {

}
