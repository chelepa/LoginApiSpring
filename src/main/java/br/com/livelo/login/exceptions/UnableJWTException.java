package br.com.livelo.login.exceptions;

public class UnableJWTException extends RuntimeException{

	private static final long serialVersionUID = -368915781962047973L;
	
	public UnableJWTException(String msg) {
		super(msg);
	}

}
