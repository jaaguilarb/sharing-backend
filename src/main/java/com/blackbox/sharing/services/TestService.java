package com.blackbox.sharing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackbox.sharing.domain.Test;
import com.blackbox.sharing.domain.Topic;
import com.blackbox.sharing.repositories.TestRepository;
import com.blackbox.sharing.services.exceptions.ObjectNotFoundException;

@Service
public class TestService {
	@Autowired
	private TestRepository reposit;
	public Test find(Integer id) {
		Test test = reposit.findOne(id);
		if (test == null) {
			throw new ObjectNotFoundException("Object Not Found! Id: " + id
					+ ", Type: " + Topic.class.getName());
		}

		return test;
	}
}
