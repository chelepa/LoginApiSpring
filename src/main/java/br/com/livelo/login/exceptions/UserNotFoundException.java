package br.com.livelo.login.exceptions;

public class UserNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 8723653622319071355L;

	public UserNotFoundException(String msg) {
		super(msg);
	}

}
