package br.com.livelo.login.exceptions;

public class ExpiredJWTException extends RuntimeException{

	private static final long serialVersionUID = -368915781962047973L;
	
	public ExpiredJWTException(String msg) {
		super(msg);
	}

}
