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
import org.springframework.test.context.junit4.SpringRunner;

import br.com.livelo.login.entities.Users;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JwtUserDetailsServiceTest {
	
	private static final String LOGIN = "03300121000";
	private static final String PASSWORD = "03300121000";

	@MockBean
	private UserServiceImpl userServiceImpl;
	
	@Autowired
	private JwtUserDetailsService jwtUserDetailsService;
	
	private List<Users> user;
	
	@Before
	public void setup() {
		user = Arrays.asList(listUsers());
		when(userServiceImpl.findByLogin(toString())).thenReturn(user);
	}

	@Test
	public void loadUserByUsernameSucess() {
		jwtUserDetailsService.setLogin(LOGIN);
		jwtUserDetailsService.setPass(PASSWORD);
		jwtUserDetailsService.loadUserByUsername(LOGIN);
	}
	
	@Test(expected = Exception.class)
	public void loadUserByUsernameError() {
		jwtUserDetailsService.setLogin("");
		jwtUserDetailsService.loadUserByUsername(LOGIN);
	}
	
//	@Test
//	public void setLoginAndPasswordSucess() {
//		jwtUserDetailsService.setLogin(null);
//		jwtUserDetailsService.setPass(null);
//		jwtUserDetailsService.loadUserByUsername(LOGIN);
//	}
	
	private Users listUsers() {
		Users users = new Users();
		users.setPassword("03300121000");
		users.setLogin("03300121000");
		return users;
	}

}
