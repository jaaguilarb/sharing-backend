package com.blackbox.sharing.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.blackbox.sharing.domain.Role;
import com.blackbox.sharing.services.RoleService;

@RestController
@RequestMapping(value = "/role")
public class RoleResource {
	@Autowired
	private RoleService service;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Role> find(@PathVariable Integer id) {
		Role role = service.find(id);

		return ResponseEntity.ok().body(role);
	}

	@RequestMapping(method=RequestMethod.POST)
	public ResponseEntity<Void> insert(@RequestBody Role role) {
		role = service.insert(role);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}").buildAndExpand(role.getId()).toUri();

		return ResponseEntity.created(uri).build();
	}

	@RequestMapping(value = "/{id}", method=RequestMethod.PUT)
	public ResponseEntity<Void> update(@RequestBody Role role, @PathVariable Integer id) {
		role.setId(id);
		role = service.update(role);

		return ResponseEntity.noContent().build();
	}
}
