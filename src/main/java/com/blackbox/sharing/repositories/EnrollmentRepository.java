/**
 * 
 */
package com.blackbox.sharing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackbox.sharing.domain.Enrollment;

/**
 * @author joseph
 *
 */
@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Integer> {

}