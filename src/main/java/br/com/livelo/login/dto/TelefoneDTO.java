package br.com.livelo.login.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class TelefoneDTO implements Serializable {

	private static final long serialVersionUID = -4961689682387816151L;

	private String codArea;
	private String numero;
	private String tipoTelefone;
}
