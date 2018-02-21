/**
 * 
 */
package com.blackbox.sharing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackbox.sharing.domain.Lesson;

/**
 * @author joseph
 *
 */
@Repository
public interface LessonRepository extends JpaRepository<Lesson, Integer> {

}