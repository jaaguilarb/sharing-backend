/**
 * 
 */
package com.blackbox.sharing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackbox.sharing.domain.QA;

/**
 * @author joseph
 *
 */
@Repository
public interface QARepository extends JpaRepository<QA, Integer> {

}