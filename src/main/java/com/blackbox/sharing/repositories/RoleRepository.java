/**
 * 
 */
package com.blackbox.sharing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackbox.sharing.domain.Role;

/**
 * @author joseph
 *
 */
@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

}