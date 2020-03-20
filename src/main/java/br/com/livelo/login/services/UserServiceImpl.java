package br.com.livelo.login.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.com.livelo.login.entities.Users;
import br.com.livelo.login.exceptions.LoginRequestException;
import br.com.livelo.login.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userServiceImpl;

	@Override
	public List<Users> findByLogin(String login) {
		return userServiceImpl.findByLogin(login);
	}
	
	@Override
	public List<Users> findByCPF(String CPF) {
		return userServiceImpl.findByCpf(CPF);
	}

	@Override
	public Users saveProfile(Users users) throws Exception {
		if (!findByCPF(users.getCpf()).isEmpty()) {
			throw new LoginRequestException("CPF ja em uso");
		}
		users.setPassword(new BCryptPasswordEncoder().encode(users.getPassword()));
		return userServiceImpl.insert(users);
	}
}
