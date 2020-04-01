package br.com.livelo.login.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.livelo.login.dto.JwtResponseDTO;
import br.com.livelo.login.dto.LoginAuthenticateDTO;
import br.com.livelo.login.services.AuthenticateSecurity;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticateSecurity authenticateSecurity;

	@PostMapping(value = "/v1/login")
	public ResponseEntity<JwtResponseDTO> createAuthenticationToken(@RequestBody LoginAuthenticateDTO authenticate) throws Exception {
		return ResponseEntity.ok(new JwtResponseDTO(authenticateSecurity.authenticate(authenticate)));
	}
	
	@PostMapping(value = "/customer/v1/reset")
	private ResponseEntity<Boolean> checkRoute() throws Exception {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(Boolean.TRUE);	
	}
}
