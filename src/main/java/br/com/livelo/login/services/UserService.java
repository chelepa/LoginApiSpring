package br.com.livelo.login.services;

import java.util.List;

import br.com.livelo.login.entities.Users;

public interface UserService {

	List<Users> findByLogin(String login);
	
	Users saveProfile(Users users);

	List<Users> findByCPF(String CPF);
}
