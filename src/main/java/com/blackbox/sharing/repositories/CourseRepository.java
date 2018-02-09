/**
 * 
 */
package com.blackbox.sharing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackbox.sharing.domain.Course;

/**
 * @author joseph
 *
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {

}