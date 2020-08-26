/**
 * 
 */
package com.jpademo3.service;

import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpademo3.entities.Department;
import com.jpademo3.repositories.DepartmentRepository;

/**
 * @author User
 *
 */
@Service
public class DepartmentService {

	@Autowired
	private DepartmentRepository departmentRepository;

	@Transactional
	public Department getDept(Integer deptID) {
		Optional<Department> optDeptByID = departmentRepository.findById(deptID);

		if (optDeptByID.isPresent()) {
			System.out.println(optDeptByID.get());
		}

		return optDeptByID.isPresent() ? optDeptByID.get() : null;
	}

}
