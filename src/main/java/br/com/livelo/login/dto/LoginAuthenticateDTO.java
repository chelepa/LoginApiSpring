package br.com.livelo.login.dto;

import lombok.Data;

@Data
public class LoginAuthenticateDTO {

	private String login;
	private String password;

	public LoginAuthenticateDTO() {
		
	}
	
	public LoginAuthenticateDTO(String login, String password) {
		this.setLogin(login);
		this.setPassword(password);
	}
	
}
