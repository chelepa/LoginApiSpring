package br.com.livelo.login.services.LoginService;

import br.com.livelo.login.entities.UsersEntity;

public interface LoginService {

	UsersEntity findByLogin(String login);
	
	
}
