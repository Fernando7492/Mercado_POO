package com.example.Mercado_POO.basica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Endereco {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String logradouro;
	private String uf;
	private String cidade;
	private String bairro;
	private String numero;
	private String cep;
	
	public Endereco(String logradouro, String uf, String cidade, String bairro, String numero, String cep) {
		super();
		this.logradouro = logradouro;
		this.uf = uf;
		this.cidade = cidade;
		this.bairro = bairro;
		this.numero = numero;
		this.cep = cep;
	}
	
	private Endereco() {
		super();
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getLogradouro() {
		return logradouro;
	}
	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}
	public String getUf() {
		return uf;
	}
	public void setUf(String uf) {
		this.uf = uf;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	public String getNumero() {
		return numero;
	}
	public void setNumero(String numero) {
		this.numero = numero;
	}
	public String getCep() {
		return cep;
	}
	public void setCep(String cep) {
		this.cep = cep;
	}
	@Override
	public String toString() {
		return "Endereco [id=" + id + ", logradouro=" + logradouro + ", uf=" + uf + ", cidade=" + cidade + ", bairro="
				+ bairro + ", numero=" + numero + ", cep=" + cep + "]";
	}
	
	
}
