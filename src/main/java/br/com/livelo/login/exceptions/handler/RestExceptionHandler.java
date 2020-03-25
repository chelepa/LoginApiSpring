package br.com.livelo.login.exceptions.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
import br.com.livelo.login.constants.*;
import br.com.livelo.login.exceptions.*;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler{
	
	private static final String LOG_ERROR = "An unexpected error occur";
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		logger.error(LOG_ERROR, ex);

		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.INTERNAL_SERVER_ERROR, ex.getMessage());

		request.getDescription(false);

		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
	}
	
	@ExceptionHandler(LoginRequestException.class)
	public ResponseEntity<Object> handleCustomerBadRequestException(LoginRequestException ex) {
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.CPF_ALREADY_REGISTERED, ex.getMessage());

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exceptionResponse);
	}
	
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<Object> invalidCredentialsException(InvalidCredentialsException msg){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.INVALID_CREDENTIALS, msg.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
	}
	
	

}
