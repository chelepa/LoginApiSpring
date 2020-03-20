package br.com.livelo.login.services;

import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.livelo.login.dto.LoginAuthenticateDTO;
import br.com.livelo.login.jwt.JwtTokenUtil;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;

@Service
public class AuthenticateSecurity {

	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	@Autowired
	private JwtUserDetailsService userDetailsService;

	public String authenticate(LoginAuthenticateDTO authenticate) throws Exception {
		
		String login = authenticate.getLogin();
		String password = authenticate.getPassword();

		try {
			authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(login, password)).isAuthenticated();
			return token(login);
		} catch (DisabledException e) {
			throw new Exception("USER_DISABLED", e);
		} catch (BadCredentialsException e) {
			throw new Exception("INVALID_CREDENTIALS", e);
		}
	}

	private String token(String login) throws Exception {
		UserDetails userDetails = userDetailsService.loadUserByUsername(login);
		return jwtTokenUtil.generateToken(userDetails);
	}

}
