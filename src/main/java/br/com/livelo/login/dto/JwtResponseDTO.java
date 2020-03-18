package br.com.livelo.login.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtResponseDTO implements Serializable {
	
	private static final long serialVersionUID = -8091879091924046844L;
	private final String jwttoken;

	public JwtResponseDTO(String jwttoken) {
		this.jwttoken = jwttoken;
	}
}