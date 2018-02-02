/**
 * 
 */
package com.blackbox.sharing.ws;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blackbox.sharing.domain.Person;

/**
 * @author joseph
 *
 */
@RestController
@RequestMapping(value="/persons")
public class PersonRest {
	@RequestMapping(method=RequestMethod.GET)
	public List<Person> test() {
		Person p1 = new Person(1, "Alba", "alba@gmail.com");
		Person p2 = new Person(2, "Ikram", "ikram@email.com");
		Person p3 = new Person(3, "Alba", "danis@email.com");
		List<Person> list = new ArrayList<>();
		list.add(p1);
		list.add(p2);
		list.add(p3);

		return list;
	}
}