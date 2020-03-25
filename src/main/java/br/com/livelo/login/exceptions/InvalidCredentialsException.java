package br.com.livelo.login.exceptions;

public class InvalidCredentialsException extends RuntimeException{

	private static final long serialVersionUID = 2484828166612620380L;
	
	public  InvalidCredentialsException(String msg) {
		super(msg);
	}

}
