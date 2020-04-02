package br.com.livelo.login.services;

import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.livelo.login.entities.UsersEntity;
import br.com.livelo.login.exceptions.InvalidCredentialsException;
import br.com.livelo.login.exceptions.LoginNullException;
import br.com.livelo.login.exceptions.UserNotFoundException;
import br.com.livelo.login.services.LoginService.LoginServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JwtUserDetailsServiceTest {
	
	private static final String LOGIN = "03300121000";
	private static final String PASSWORD = "03300121000";

	@MockBean
	private LoginServiceImpl userServiceImpl;
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	

	@Test
	public void loadUserByUsernameSucess() {
		when(userServiceImpl.findByLogin(LOGIN)).thenReturn(findByUsers());
		jwtUserDetailsService.loadUserByUsername(LOGIN);
	}
	
	@Test(expected = LoginNullException.class)
	public void loadUserByUsernameError() {
		jwtUserDetailsService.loadUserByUsername(null);
	}
	
	@Test(expected = UserNotFoundException.class)
	public void loadUserNotFound() {
		when(userServiceImpl.findByLogin(LOGIN)).thenReturn(null);
		jwtUserDetailsService.loadUserByUsername(LOGIN);
	}
	
	private UsersEntity findByUsers() {
		UsersEntity users = new UsersEntity();
		users.setLogin(LOGIN);
		users.setPassword(PASSWORD);
		return users;
	}
	
	
}
