package br.com.livelo.login.dto;

import lombok.Data;

@Data
public class LoginAuthenticateDTO {

	private String username;
	private String password;

	public LoginAuthenticateDTO() {
		
	}
	
	public LoginAuthenticateDTO(String username, String password) {
		this.setUsername(username);
		this.setPassword(password);
	}
	
}
