package com.blackbox.sharing.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.blackbox.sharing.domain.Course;
import com.blackbox.sharing.services.CourseService;

@RestController
@RequestMapping(value = "/course")
public class CourseResource {
	@Autowired
	private CourseService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> find(@PathVariable Integer id) {
		Course course = service.find(id);

		return ResponseEntity.ok().body(course);
	}
}
