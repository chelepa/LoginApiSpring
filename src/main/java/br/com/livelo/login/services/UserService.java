package br.com.livelo.login.services;

import java.util.List;

import br.com.livelo.login.entities.Users;

public interface UserService {

	List<Users> findByname(String nome);

}
