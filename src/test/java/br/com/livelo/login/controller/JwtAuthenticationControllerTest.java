package br.com.livelo.login.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.web.context.WebApplicationContext;

import br.com.livelo.login.dto.JwtResponseDTO;
import br.com.livelo.login.dto.LoginAuthenticateDTO;
import br.com.livelo.login.services.AuthenticateSecurity;
import br.com.livelo.login.util.TestUtil;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class JwtAuthenticationControllerTest {

	private static final String URL_JwtAuthentication = "/v1/login";
	private static final String LOGIN = "03300121000";
	private static final String PASS = "Pontos#8759";
	
	private static final String JWT = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiIwMzMwMDEyMTAwMCIsImV4cCI6MTU4NTAwODEzOSwiaWF0IjoxNTg0OTkwMTM5fQ.BpuE-4T_PFqqne83259BXa7dXKsvV0d2EjMnYBwdTcYYQJ59Ko8thyfnNe9Foj1Y0ekTvT9EsaGVn4Y51iRJmw";
	
	@Autowired
	private MockMvc mockMvc;
	
	
	@MockBean
	private AuthenticateSecurity authenticateSecurity;
		
	@Test
	public void login() throws Exception {
		String URI = URL_JwtAuthentication;
		
		String jsonFile = TestUtil.readJsonFile("json/Login.json");
		
		when(authenticateSecurity.authenticate(null)).thenReturn(JWT);
		
		RequestBuilder requestBuilder = MockMvcRequestBuilders
				.post(URI)
				.accept(MediaType.APPLICATION_JSON)
				.content(jsonFile)
				.contentType(MediaType.APPLICATION_JSON);
				
		MvcResult result = mockMvc.perform(requestBuilder).andReturn();
		MockHttpServletResponse response = result.getResponse();
		
		assertEquals(HttpStatus.OK.value(), response.getStatus());
	}

}
