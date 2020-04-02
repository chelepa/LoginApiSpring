package br.com.livelo.login.services.LoginService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.livelo.login.dto.UrlCheckDTO;
import br.com.livelo.login.entities.UsersEntity;
import br.com.livelo.login.repositories.UserRepository;
import br.com.livelo.login.security.URLConfiguration;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	private UserRepository userRepository;
		
	@Override
	public UsersEntity findByLogin(String login) {
		return userRepository.findByLogin(login);
	}
}
