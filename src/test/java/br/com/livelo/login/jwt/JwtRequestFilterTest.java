package br.com.livelo.login.jwt;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.mock.web.MockFilterChain;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.livelo.login.entities.Users;
import br.com.livelo.login.exceptions.ExpiredJWTException;
import br.com.livelo.login.exceptions.UnableJWTException;
import br.com.livelo.login.services.JwtUserDetailsService;
import io.jsonwebtoken.ExpiredJwtException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtRequestFilterTest {

	private static final String TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIwMzMwMDEyMTAwMCIsImV4cCI6MTU4NTI1MDY2MywiaWF0IjoxNTg1MjMyNjYzfQ.ZqWd-GFR8pFymifzFc5Xs_FSoTVgxJffKAKgrhE3jqyDKLpzUsAERbkM0Wnb5ASUowHorhO0FelWVyJvxlDb9g";
	private static final String LOGIN = "03300121000";
	private static final String PASSWORD = "Pontos#8759";

	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@MockBean
	private JwtTokenUtil jwtTokenUtil;

	@MockBean
	private JwtUserDetailsService jwtUserDetailsService;

	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	private FilterChain filterChain;
	private UserDetails userDetails;
	
	@Before
	public void setup() {
		userDetails = userDetail();
		when(jwtTokenUtil.getUsernameFromToken(TOKEN)).thenReturn(LOGIN);
		when(jwtUserDetailsService.loadUserByUsername(LOGIN)).thenReturn(userDetails);

		request = new MockHttpServletRequest("POST", "/v1/login");
		response = new MockHttpServletResponse();
		filterChain = new MockFilterChain();
	}

	@Test
	public void doFilterInternalsucessTest() throws ServletException, IOException {
		request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + TOKEN);
		jwtRequestFilter.doFilterInternal(request, response, filterChain);
	}

	@Test
	public void doFilterInternalErrorTest() throws ServletException, IOException {
		MockHttpServletRequest request = new MockHttpServletRequest("POST", "/v1/login");
		jwtRequestFilter.doFilterInternal(request, response, filterChain);

	}

	@Test(expected = UnableJWTException.class)
	public void doFilterInternalUnableJWTExceptionTest() throws ServletException, IOException {
		when(jwtTokenUtil.getUsernameFromToken(TOKEN)).thenThrow(new IllegalArgumentException());
		request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + TOKEN);
		jwtRequestFilter.doFilterInternal(request, response, filterChain);
	}
	
	@Test(expected = ExpiredJwtException.class)
	public void doFilterInternalExpiredJwtExceptionTest() throws ServletException, IOException {
		when(jwtTokenUtil.getUsernameFromToken(TOKEN)).thenThrow(new ExpiredJWTException(null));
		request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + TOKEN);
		jwtRequestFilter.doFilterInternal(request, response, filterChain);
	}
	
	@Test
	public void JWTValidateFalse() throws ServletException, IOException {
		when(jwtTokenUtil.validateToken(TOKEN, userDetails)).thenReturn(Boolean.FALSE);
		request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + TOKEN);
		jwtRequestFilter.doFilterInternal(request, response, filterChain);

	}
	
	@Test
	public void JWTValidateTrue() throws ServletException, IOException {
		when(jwtTokenUtil.validateToken(TOKEN, userDetails)).thenReturn(Boolean.TRUE);
		request.addHeader(HttpHeaders.AUTHORIZATION, "Bearer " + TOKEN);
 		jwtRequestFilter.doFilterInternal(request, response, filterChain);
	}
		
	

	private User userDetail() {
		Users users = new Users();
		users.setLogin(LOGIN);
		users.setPassword(PASSWORD);
		return new User(users.getLogin(), users.getPassword(), new ArrayList<>());
	}

}
