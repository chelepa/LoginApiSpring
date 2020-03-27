package br.com.livelo.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.livelo.login.entities.UsersEntity;
import br.com.livelo.login.services.UserServiceImpl;

@RestController
@CrossOrigin
public class CustomerController {
	
	@Autowired
	private UserServiceImpl userServiceImpl;
	
	@PostMapping(value = "/customer/v1/create")
	public ResponseEntity<UsersEntity> createProfile (@RequestBody UsersEntity users) throws Exception {
		return ResponseEntity.ok(userServiceImpl.saveProfile(users));
	}
}
