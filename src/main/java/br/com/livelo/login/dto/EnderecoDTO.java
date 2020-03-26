package br.com.livelo.login.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class EnderecoDTO implements Serializable {

	private String pais;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;
	private String complemento;
	private String cep;

}
