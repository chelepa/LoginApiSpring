package br.com.livelo.login.entities;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "user")
@Data
public class UsersEntity implements Serializable{

	private static final long serialVersionUID = -8532630533890633991L;
	
	@Id
	private String id;
	private String username;
	private String lastname;
	private String login;
	private String password;
	private String email;
	private String cpf;
	private List<RolesEntity> roles;
	private List<EnderecoEntity> endereço;
	private List<TelefoneEntity> telefone;
	
}
