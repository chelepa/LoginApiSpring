package br.com.livelo.login.security;

import org.springframework.stereotype.Component;

@Component
public class URLConfiguration {
		
	public String[] permitAll() {
		String[] pathArray = new String[]
		{
		    "/v1/login",
		    "/customer/v1/create",
            "/swagger-resources",
            "/swagger-resources/**",
            "/configuration/ui",
            "/configuration/security",
            "/swagger-ui.html",
            "/webjars/**",
		};
		return pathArray;
	}
	
	public String[] USR() {
		String[] USR = new String[]
		{
		    "/customer/v1/reset"
		};
		return USR;
	}
	
	public String[] ADM() {
		String[] ADM = new String[]
		{
		    "/customer/v1/reset"
		};
		return ADM;
	}
	

}
