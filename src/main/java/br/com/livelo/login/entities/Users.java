package br.com.livelo.login.entities;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import br.com.livelo.login.dto.EnderecoDTO;
import br.com.livelo.login.dto.RolesDTO;
import br.com.livelo.login.dto.TelefoneDTO;
import lombok.Data;

@Document(collection = "user")
@Data
public class Users implements Serializable{

	private static final long serialVersionUID = -8532630533890633991L;
	
	@Id
	private String id;
	private String username;
	private String lastname;
	private String login;
	private String password;
	private String email;
	private String cpf;
	private List<RolesDTO> roles;
	private List<EnderecoDTO> endereço;
	private List<TelefoneDTO> telefone;
	
}
