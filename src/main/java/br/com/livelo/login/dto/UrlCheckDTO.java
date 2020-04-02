package br.com.livelo.login.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UrlCheckDTO implements Serializable {
	
	private static final long serialVersionUID = -1219195312447025493L;
	
	private String url;

	public UrlCheckDTO() {

	}

	public UrlCheckDTO(String URL) {
		this.setUrl(URL);
	}

}
