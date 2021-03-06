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
	
	@ExceptionHandler(LoginNullException.class)
	public ResponseEntity<Object> loginNotFoundException(LoginNullException msg){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.LOGIN_NULL, msg.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
	}
	
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<Object> userNotFoundException(UserNotFoundException msg){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.USER_NOT_FOUND, msg.getMessage());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exceptionResponse);
	}
	
	@ExceptionHandler(UnableJWTException.class)
	public ResponseEntity<Object> unableJWT(UnableJWTException msg){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.UNABLE_TO_GET_JWT, msg.getMessage());
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exceptionResponse);
	}
	
	@ExceptionHandler(ExpiredJWTException.class)
	public ResponseEntity<Object> expiredJWTException(ExpiredJWTException msg){
		ExceptionResponse exceptionResponse = new ExceptionResponse(ErrorCodes.JWT_EXPIRED, msg.getMessage());
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(exceptionResponse);
	}
}
