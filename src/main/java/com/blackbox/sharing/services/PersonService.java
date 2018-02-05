/**
 * 
 */
package com.blackbox.sharing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackbox.sharing.domain.Person;
import com.blackbox.sharing.repositories.PersonRepository;

/**
 * @author joseph
 *
 */
@Service
public class PersonService {
	@Autowired
	private PersonRepository personR;

	public Person find(Integer id) {
		Person person = personR.findOne(id);

		return person;
	}
}