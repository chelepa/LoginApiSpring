package br.com.livelo.login.services;

import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.livelo.login.entities.UsersEntity;
import br.com.livelo.login.exceptions.LoginRequestException;
import br.com.livelo.login.repositories.UserRepository;
import br.com.livelo.login.services.LoginService.LoginService;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserServiceImplTest {

	@MockBean
	private UserRepository userRepository;

	@Autowired
	private LoginService userService;

	@Test
	public void findByLogin_sucess() {
		when(userRepository.findByLogin(toString())).thenReturn(users());
		userService.findByLogin(toString());
	}

	@Test
	public void findByLogin_Error() {
		when(userRepository.findByLogin(toString())).thenReturn(null);
		userService.findByLogin(toString());
	}

	private UsersEntity users() {
		UsersEntity users = new UsersEntity();
		users.setPassword("03300121000");
		users.setCpf("03300121000");
		return users;
	}
	
}
