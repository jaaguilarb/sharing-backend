package com.blackbox.sharing.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blackbox.sharing.domain.Role;
import com.blackbox.sharing.repositories.RoleRepository;
import com.blackbox.sharing.services.exceptions.ObjectNotFoundException;

@Service
public class RoleService {
	@Autowired
	private RoleRepository reposit;
	public Role find(Integer id) {
		Role role = reposit.findOne(id);
		if (role == null) {
			throw new ObjectNotFoundException("Object Not Found! Id: " + id
					+ ", Type: " + Role.class.getName());
		}

		return role;
	}
}
