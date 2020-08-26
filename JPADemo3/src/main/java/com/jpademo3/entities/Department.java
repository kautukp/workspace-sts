/**
 * 
 */
package com.jpademo3.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.cache.annotation.Cacheable;

/**
 * @author User
 *
 */
@Entity
@Table(name = "DEPARTMENT")
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
public class Department {

	@Id
	@Column(name = "DEPT_ID")
	private Integer deptID;

	@Column(name = "DEPT_NAME")
	private String deptName;

	/**
	 * 
	 */
	public Department() {
		super();
	}

	public Department(Integer deptID, String deptName) {
		super();
		this.deptID = deptID;
		this.deptName = deptName;
	}

	/**
	 * @return the deptID
	 */
	public Integer getDeptID() {
		return deptID;
	}

	/**
	 * @param deptID the deptID to set
	 */
	public void setDeptID(Integer deptID) {
		this.deptID = deptID;
	}

	/**
	 * @return the deptName
	 */
	public String getDeptName() {
		return deptName;
	}

	/**
	 * @param deptName the deptName to set
	 */
	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	@Override
	public String toString() {
		return "Department [deptID=" + deptID + ", deptName=" + deptName + "]";
	}

}
