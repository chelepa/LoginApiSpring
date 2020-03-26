package br.com.livelo.login.jwt;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.livelo.login.entities.Users;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTokenUtilTest {
	
	private static final String TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIwMzMwMDEyMTAwMCIsImV4cCI6MTU4NTI2OTAwMywiaWF0IjoxNTg1MjUxMDAzfQ.uS9u-9nTZm7hVUzCQ13U-Aem28L0pidp9B5P4hAlJD5Vfhc43NyVZhoi9vpm94jbR8RPUj9MAoZnO4aUCIpdLQ";
	private static final String LOGIN = "03300121000";
	private static final String PASSWORD = "Pontos#8759";
	
	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Test
	public void UsernameFromTokenTest() {
		jwtTokenUtil.getUsernameFromToken(TOKEN);
	}
	
	@Test
	public void expirationDateFromToken() {
		jwtTokenUtil.getExpirationDateFromToken(TOKEN);
	}
	
	@Test
	public void generateToken() {
		UserDetails userDetails = userDetail();
		jwtTokenUtil.generateToken(userDetails);
	}
	
	@Test
	public void validateToken() {
		UserDetails userDetails = userDetail();
		jwtTokenUtil.validateToken(TOKEN, userDetails);
	}
	
	private User userDetail() {
		Users users = new Users();
		users.setLogin(LOGIN);
		users.setPassword(PASSWORD);
		return new User(users.getLogin(), users.getPassword(), new ArrayList<>());
	}

}
