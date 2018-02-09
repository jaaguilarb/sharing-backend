/**
 * 
 */
package com.blackbox.sharing.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blackbox.sharing.domain.Member;

/**
 * @author joseph
 *
 */
@Repository
public interface MemberRepository extends JpaRepository<Member, Integer> {

}