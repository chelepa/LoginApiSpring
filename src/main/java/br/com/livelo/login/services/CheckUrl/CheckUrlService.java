package br.com.livelo.login.services.CheckUrl;

import java.util.List;

import br.com.livelo.login.dto.UrlCheckDTO;

public interface CheckUrlService {

	Boolean checkUrl(UrlCheckDTO URL);
	
	List<String> Authorities();
	
	List<String> permitAll();
	
	List<String> USR();
	
	List<String> ADM();

}