/**
 * 
 */
package com.jpademo.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpademo.entities.CD;

/**
 * @author User
 *
 */
@Repository
public interface CDRepository extends CrudRepository<CD, Integer> {

	List<CD> findByUnitCostGreaterThan(Double unitCost) throws Exception;

	List<CD> findByTitleIgnoreCase(String title) throws Exception;
	
}
