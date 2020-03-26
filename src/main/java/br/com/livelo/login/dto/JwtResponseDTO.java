package br.com.livelo.login.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class JwtResponseDTO implements Serializable {

	private final String jwttoken;

	public JwtResponseDTO(String jwttoken) {
		this.jwttoken = jwttoken;
	}
}