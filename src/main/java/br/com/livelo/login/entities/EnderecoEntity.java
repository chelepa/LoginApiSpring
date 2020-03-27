package br.com.livelo.login.entities;

import java.io.Serializable;

import lombok.Data;

@Data
public class EnderecoEntity implements Serializable {

	private String pais;
	private String estado;
	private String cidade;
	private String bairro;
	private String rua;
	private String numero;
	private String complemento;
	private String cep;

}
