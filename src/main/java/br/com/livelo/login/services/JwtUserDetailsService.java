package br.com.livelo.login.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import br.com.livelo.login.entities.UsersEntity;
import br.com.livelo.login.exceptions.LoginNullException;
import br.com.livelo.login.exceptions.UserNotFoundException;
import br.com.livelo.login.services.LoginService.LoginServiceImpl;

import org.apache.commons.lang3.StringUtils;

@Service
public class JwtUserDetailsService implements UserDetailsService {

	@Autowired
	private LoginServiceImpl userServiceImpl;

	@Override
	public UserDetails loadUserByUsername(String login) {
		if (StringUtils.isNotBlank(login)) {
			UsersEntity User = userServiceImpl.findByLogin(login);
			if (User != null) {
				return new User(User.getLogin(), User.getPassword(), User.getRoles());
			}else {
				throw new UserNotFoundException("Usuario não encontrado");
			}
		}else {
			throw new LoginNullException("Login NULL");
		}
	}
}
