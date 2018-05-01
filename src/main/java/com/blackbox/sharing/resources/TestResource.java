package com.blackbox.sharing.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blackbox.sharing.domain.Test;
import com.blackbox.sharing.services.TestService;

@RestController
@RequestMapping(value = "/test")
public class TestResource {
	@Autowired
	private TestService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Test test = service.find(id);

		return ResponseEntity.ok().body(test);
	}
}
