package br.com.livelo.login.exceptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.context.request.WebRequest;

import br.com.livelo.login.exceptions.handler.RestExceptionHandler;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RestExceptionHandlerTest {
	
	@Autowired
	private WebRequest request;
	
	@Autowired RestExceptionHandler restExceptionHandler;
	
	@Test
	public void handleAllExceptionsTest() {
		Exception ex = new Exception();
		ResponseEntity<?> response = restExceptionHandler.handleAllExceptions(ex, request);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}
	
	@Test
	public void handleCustomerBadRequestExceptionTest() {
		LoginRequestException ex = new LoginRequestException(null);
		ResponseEntity<?> response = restExceptionHandler.handleCustomerBadRequestException(ex);
		assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
	}
	
	@Test
	public void invalidCredentialsExceptionTest() {
		InvalidCredentialsException ex = new InvalidCredentialsException(null);
		ResponseEntity<?> response = restExceptionHandler.invalidCredentialsException(ex);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}
	
	@Test
	public void loginNotFoundExceptionTest() {
		LoginNullException ex = new LoginNullException(null);
		ResponseEntity<?> response = restExceptionHandler.loginNotFoundException(ex);
		assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
	}
	
	@Test
	public void userNotFoundExceptionTest() {
		UserNotFoundException ex = new UserNotFoundException(null);
		ResponseEntity<?> response = restExceptionHandler.userNotFoundException(ex);
		assertEquals(HttpStatus.NOT_FOUND, response.getStatusCode());
	}
}
