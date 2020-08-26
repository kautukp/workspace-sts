/**
 * 
 */
package com.jpademo.repositories;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jpademo.entities.Musicians;

/**
 * @author User
 *
 */
@Repository
public interface MusicianRepository extends CrudRepository<Musicians, Integer> {

	Optional<Musicians> findByNameStartingWith(String name) throws Exception;

}
