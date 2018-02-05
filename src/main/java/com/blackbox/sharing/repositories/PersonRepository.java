/**
 * 
 */
package com.blackbox.sharing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackbox.sharing.domain.Person;

/**
 * @author joseph
 *
 */
@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

}