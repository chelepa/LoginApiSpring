package br.com.livelo.login.exceptions;

public class LoginRequestException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public LoginRequestException(String msg) {
		super(msg);
	}

}
