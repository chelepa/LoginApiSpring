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
import br.com.livelo.login.dto.UrlCheckDTO;
import br.com.livelo.login.services.AuthenticateSecurity;
import br.com.livelo.login.services.CheckUrl.CheckUrlService;

@RestController
@CrossOrigin
public class JwtAuthenticationController {

	@Autowired
	private AuthenticateSecurity authenticateSecurity;
	
	@Autowired 
	private CheckUrlService checkurlservice;

	@PostMapping(value = "/v1/login")
	public ResponseEntity<JwtResponseDTO> createAuthenticationToken(@RequestBody LoginAuthenticateDTO authenticate) throws Exception {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(new JwtResponseDTO(authenticateSecurity.authenticate(authenticate)));
	}
	
	@PostMapping(value = "/v1/CheckUrl")
	private ResponseEntity<Boolean> checkRoute(@RequestBody UrlCheckDTO URL) throws Exception {
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(checkurlservice.checkUrl(URL));	
	}
}
