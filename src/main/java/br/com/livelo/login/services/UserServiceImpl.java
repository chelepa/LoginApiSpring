package br.com.livelo.login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.livelo.login.entities.UsersEntity;
import br.com.livelo.login.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userServiceImpl;

	@Override
	public UsersEntity findByLogin(String login) {
		return userServiceImpl.findByLogin(login);
	}	
}
