/**
 * 
 */
package com.jpademo3.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpademo3.entities.Employee;
import com.jpademo3.repositories.EmployeeRepository;

/**
 * @author User
 *
 */
@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	@Transactional
	public Employee getEmp(Long empID) {
		Optional<Employee> optEmpByID = employeeRepository.findById(empID);

		if (optEmpByID.isPresent()) {
			System.out.println(optEmpByID.get());
		}

		return optEmpByID.isPresent() ? optEmpByID.get() : null;
	}

}
