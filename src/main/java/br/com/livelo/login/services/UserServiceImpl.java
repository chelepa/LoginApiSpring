package br.com.livelo.login.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.livelo.login.entities.UsersEntity;
import br.com.livelo.login.exceptions.LoginRequestException;
import br.com.livelo.login.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userServiceImpl;

	@Override
	public UsersEntity findByLogin(String login) {
		return userServiceImpl.findByLogin(login);
	}
	
	@Override
	public UsersEntity findByCPF(String CPF) {
		return userServiceImpl.findByCpf(CPF);
	}

	@Override
	public UsersEntity saveProfile(UsersEntity users) {
		if (findByCPF(users.getCpf()) == null) {
			String PasswordEncoder = new BCryptPasswordEncoder().encode(users.getPassword());
			users.setPassword(PasswordEncoder);
			return userServiceImpl.insert(users);
		}
		throw new LoginRequestException("CPF ja em uso");
	}
	
}
