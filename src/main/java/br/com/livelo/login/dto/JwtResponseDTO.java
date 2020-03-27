package br.com.livelo.login.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtResponseDTO implements Serializable {

	private static final long serialVersionUID = 729962459938322022L;
	
	private final String jwttoken;

	public JwtResponseDTO(String jwttoken) {
		this.jwttoken = jwttoken;
	}
}