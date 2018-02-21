/**
 * 
 */
package com.blackbox.sharing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackbox.sharing.domain.Test;

/**
 * @author joseph
 *
 */
@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {

}