package br.com.livelo.login.services;

import br.com.livelo.login.entities.UsersEntity;

public interface UserService {

	UsersEntity findByLogin(String login);
}
