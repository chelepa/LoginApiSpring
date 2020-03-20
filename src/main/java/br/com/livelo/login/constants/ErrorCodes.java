package br.com.livelo.login.constants;

public enum ErrorCodes {
	
	CPF_ALREADY_REGISTERED("cpf already registered"),
	INTERNAL_SERVER_ERROR("Internal server error");

	private final String message;
	
	ErrorCodes(String message) {
		this.message = message;
	}

	public String getMessage() {
		return this.message;
	}

}