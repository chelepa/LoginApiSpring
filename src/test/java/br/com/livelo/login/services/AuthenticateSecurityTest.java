package br.com.livelo.login.services;

import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.livelo.login.dto.LoginAuthenticateDTO;
import br.com.livelo.login.exceptions.InvalidCredentialsException;
import br.com.livelo.login.jwt.JwtTokenUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class AuthenticateSecurityTest {

	@MockBean
	private AuthenticationManager authenticationManager;

	@MockBean
	private JwtTokenUtil jwtTokenUtil;

	@MockBean
	private JwtUserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticateSecurity authenticateSecurity;
	
	private UsernamePasswordAuthenticationToken authRequest;
	
	@Before
	public void setup() {
		String login = authenticateDTO().getLogin();
		String password = authenticateDTO().getPassword();
		authRequest = new UsernamePasswordAuthenticationToken(login, password);
	}

	@Test
	public void authenticate_Sucess() throws Exception {						
		when(authenticationManager.authenticate(authRequest)).thenReturn(authRequest);
		authenticateSecurity.authenticate(authenticateDTO());
	}
	
	@Test(expected = InvalidCredentialsException.class)
	public void authenticate_InvalidCredentials() throws Exception {
		when(authenticationManager.authenticate(authRequest)).thenThrow(new BadCredentialsException(null));
		authenticateSecurity.authenticate(authenticateDTO());
	}
	@Test(expected = Exception.class)
	public void authenticate_DisabledException() throws Exception {
		when(authenticationManager.authenticate(authRequest)).thenThrow(new DisabledException(null));
		authenticateSecurity.authenticate(authenticateDTO());
	}
	
	private LoginAuthenticateDTO authenticateDTO() {
		LoginAuthenticateDTO loginAuthenticate = new LoginAuthenticateDTO();
		loginAuthenticate.setLogin("login");
		loginAuthenticate.setPassword("password");
		return loginAuthenticate;
	}
}
