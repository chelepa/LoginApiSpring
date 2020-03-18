package br.com.livelo.login.entities;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;

@Document(collection = "user")
@Data
public class Users implements Serializable{

	private static final long serialVersionUID = -8532630533890633991L;
	
	@Id
	private String id;
	private String username;
	private String password;
	
}
