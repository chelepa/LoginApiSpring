package br.com.livelo.login.constants;

public enum ErrorCodes {
	
	CPF_ALREADY_REGISTERED("cpf already registered"),
	INVALID_CREDENTIALS("invalid credentials"),
	LOGIN_NULL("login is null"),
	JWT_EXPIRED("JWT Token has expired"),
	USER_NOT_FOUND("USER NOT FOUND"),
	UNABLE_TO_GET_JWT("Unable to get JWT Token"),
	INTERNAL_SERVER_ERROR("Internal server error");

	private final String message;
	
	ErrorCodes(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}