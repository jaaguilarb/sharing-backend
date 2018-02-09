/**
 * 
 */
package com.blackbox.sharing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackbox.sharing.domain.Person;
import com.blackbox.sharing.repositories.MemberRepository;

/**
 * @author joseph
 *
 */
@Service
public class MemberService {
	@Autowired
	private MemberRepository memberR;

	public Person find(Integer id) {
		Person person = memberR.findOne(id);

		return person;
	}
}