/**
 * 
 */
package com.blackbox.sharing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackbox.sharing.domain.Topic;

/**
 * @author joseph
 *
 */
@Repository
public interface TopicRepository extends JpaRepository<Topic, Integer> {

}