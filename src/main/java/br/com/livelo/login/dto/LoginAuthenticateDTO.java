package br.com.livelo.login.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class LoginAuthenticateDTO implements Serializable {
	
	private static final long serialVersionUID = -1219195312447025493L;
	
	private String login;
	private String password;

	public LoginAuthenticateDTO() {

	}

	public LoginAuthenticateDTO(String login, String password) {
		this.setLogin(login);
		this.setPassword(password);
	}

}
