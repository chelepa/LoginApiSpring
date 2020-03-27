package br.com.livelo.login.jwt;

import java.util.ArrayList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.livelo.login.entities.UsersEntity;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtTokenUtilTest {
	
	private static final String TOKEN = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIwMzMwMDEyMTAwMCIsImV4cCI6MTU4NTM0NjY3NCwiaWF0IjoxNTg1MzI4Njc0fQ.qF13UI3UO-iAW9FAo5dhTIfc6EanUA4k4ED_l9BS9MWmmpAMyxaQKvdXYTLyB_JQDhNwDoT0Z1FaBi-lliz3Sw";
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
		UsersEntity users = new UsersEntity();
		users.setLogin(LOGIN);
		users.setPassword(PASSWORD);
		return new User(users.getLogin(), users.getPassword(), new ArrayList<>());
	}

}
