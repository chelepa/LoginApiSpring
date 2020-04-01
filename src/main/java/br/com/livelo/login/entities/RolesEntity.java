package br.com.livelo.login.entities;

import org.springframework.security.core.GrantedAuthority;

import lombok.Data;

@Data
public class RolesEntity implements GrantedAuthority {

	private static final long serialVersionUID = 1L;

	@Override
	public String getAuthority() {
		return this.nome;
	}

	private String nome;

}
