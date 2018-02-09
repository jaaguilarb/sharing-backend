/**
 * 
 */
package com.blackbox.sharing.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blackbox.sharing.domain.Person;
import com.blackbox.sharing.services.MemberService;

/**
 * @author joseph
 *
 */
@SuppressWarnings("unused")
@RestController
@RequestMapping(value="/persons")
public class PersonRest {
	@Autowired
	private MemberService service;

	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Person obj = service.find(id);
		return ResponseEntity.ok().body(obj);
	}
}