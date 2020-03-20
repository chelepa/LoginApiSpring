package br.com.livelo.login.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import br.com.livelo.login.entities.Users;
import lombok.Data;

@Data
@Service
public class JwtUserDetailsService implements UserDetailsService {

	String login;

	String pass;

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Override
	public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
		if (getLogin() == null && getPass() == null) {
			for (Users iterable_element : userServiceImpl.findByLogin(login)) {
				setLogin(iterable_element.getLogin());
				setPass(iterable_element.getPassword());
			}
		}
		if (getLogin().equals(login)) {
			return new User(getLogin(), getPass(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with Login: " + login);
		}
	}
}
