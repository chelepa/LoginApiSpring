package br.com.livelo.login.jwt;

import java.io.IOException;

import javax.servlet.ServletException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class JwtAuthenticationEntryPointTest {
	
	@Autowired
	private JwtAuthenticationEntryPoint authenticationEntryPoint;
	
	private MockHttpServletRequest request;
	private MockHttpServletResponse response;
	
	@Before
	public void setup() {
		request = new MockHttpServletRequest("POST", "/v1/login");
		response = new MockHttpServletResponse();
	}
	
	@Test
	public void commenceSucess() throws IOException, ServletException {
		authenticationEntryPoint.commence(request, response, null);
	}
	
}
