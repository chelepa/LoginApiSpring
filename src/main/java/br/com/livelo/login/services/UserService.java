package br.com.livelo.login.services;

import br.com.livelo.login.entities.Users;

public interface UserService {

	Users findByLogin(String login);
	
	Users saveProfile(Users users);

	Users findByCPF(String CPF);
}
