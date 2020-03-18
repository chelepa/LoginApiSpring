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

	String user;

	String pass;

	@Autowired
	private UserServiceImpl userServiceImpl;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		if (getUser() == null && getPass() == null) {
			for (Users iterable_element : userServiceImpl.findByname(username)) {
				setUser(iterable_element.getUsername());
				setPass(iterable_element.getPassword());
			}
		}
		if (getUser().equals(username)) {
			return new User(getUser(), getPass(), new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
}
