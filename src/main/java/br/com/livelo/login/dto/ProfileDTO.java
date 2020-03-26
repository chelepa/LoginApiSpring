package br.com.livelo.login.dto;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

@Data
public class ProfileDTO implements Serializable {

	private static final long serialVersionUID = -908612925058411783L;

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
