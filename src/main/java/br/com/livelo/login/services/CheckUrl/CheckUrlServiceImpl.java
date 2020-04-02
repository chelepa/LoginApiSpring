package br.com.livelo.login.services.CheckUrl;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import br.com.livelo.login.dto.UrlCheckDTO;
import br.com.livelo.login.security.URLConfiguration;

@Service
public class CheckUrlServiceImpl implements CheckUrlService {

	@Autowired
	private URLConfiguration urlconfiguration;
	
	public List<String> urls;
	public List<String> authorities;

	@Override
	public Boolean checkUrl(UrlCheckDTO URL) {
		for (int i = 0; i < Authorities().size(); i++) {
			if (StringUtils.equalsIgnoreCase(Authorities().get(i), "USR")) {
				for (int j = 0; j < USR().size(); j++) {
					if (StringUtils.equalsIgnoreCase(USR().get(j), URL.getUrl())) {
						return Boolean.TRUE;
					}
				}
			}
			if (StringUtils.equalsIgnoreCase(Authorities().get(i), "ADM")) {
				for (int j = 0; j < ADM().size(); j++) {
					if (StringUtils.equalsIgnoreCase(ADM().get(j), URL.getUrl())) {
						return Boolean.TRUE;
					}
				}
			}
		}
		return Boolean.FALSE;
	}

	@Override
	public List<String> permitAll() {
		urls = new ArrayList<String>();
		for (String URL : urlconfiguration.permitAll()) {
			urls.add(URL);
		}
		return urls;
	}

	@Override
	public List<String> Authorities() {
		authorities = new ArrayList<String>();
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		for (GrantedAuthority Authority : userDetails.getAuthorities()) {
			authorities.add(Authority.getAuthority());
		}
		return authorities;
	}

	@Override
	public List<String> USR() {
		urls = new ArrayList<String>();
		for (String URL : urlconfiguration.USR()) {
			urls.add(URL);
		}
		return urls;
	}

	@Override
	public List<String> ADM() {
		urls = new ArrayList<String>();
		for (String URL : urlconfiguration.ADM()) {
			urls.add(URL);
		}
		return urls;
	}
}
