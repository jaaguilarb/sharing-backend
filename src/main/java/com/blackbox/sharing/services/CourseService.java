/**
 * 
 */
package com.blackbox.sharing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackbox.sharing.domain.Course;
import com.blackbox.sharing.repositories.CourseRepository;
import com.blackbox.sharing.services.exceptions.ObjectNotFoundException;

/**
 * @author joseph
 *
 */
@Service
public class CourseService {
	@Autowired
	private CourseRepository reposit;
	public Course find(Integer id) {
		Course course = reposit.findOne(id);
		if (course == null) {
			throw new ObjectNotFoundException("Object Not Found! Id: " + id
					+ ", Type: " + Course.class.getName());
		}

		return course;
	}
}