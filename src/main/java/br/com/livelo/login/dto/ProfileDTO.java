package br.com.livelo.login.dto;

import java.util.List;

import lombok.Data;

@Data
public class ProfileDTO {

	private String username;
	private String lastname;
	private String password;
	private String login;
	private String email;
	private String cpf;
	private List<RolesDTO> roles;
	private List<EnderecoDTO> endereço;
	private List<TelefoneDTO> telefone;
	
}
