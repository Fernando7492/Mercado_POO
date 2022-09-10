package com.example.Mercado_POO.basica;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long fornecedorID;
	private String nomeFornecedor;
	private String cnpjFornecedor;
	private String emailFornecedor;
	private String telefoneFornecedor;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Endereco enderecoFornecedor;
	
	private Fornecedor() {
		super();
	}
	public Fornecedor(String nomeFornecedor, String cnpjFornecedor, String emailFornecedor, String telefoneFornecedor, Endereco enderecoFornecedor) {
		super();
		this.nomeFornecedor = nomeFornecedor;
		this.cnpjFornecedor = cnpjFornecedor;
		this.emailFornecedor = emailFornecedor;
		this.telefoneFornecedor = telefoneFornecedor;
		this.enderecoFornecedor = enderecoFornecedor;
	}
	public long getId() {
		return fornecedorID;
	}
	public void setId(long id) {
		this.fornecedorID = id;
	}
	public String getNomeFornecedor() {
		return nomeFornecedor;
	}
	public void setNomeFornecedor(String nomeFornecedor) {
		this.nomeFornecedor = nomeFornecedor;
	}
	public String getCnpjFornecedor() {
		return cnpjFornecedor;
	}
	public void setCnpjFornecedor(String cnpjFornecedor) {
		this.cnpjFornecedor = cnpjFornecedor;
	}
	public String getEmailFornecedor() {
		return emailFornecedor;
	}
	public void setEmailFornecedor(String emailFornecedor) {
		this.emailFornecedor = emailFornecedor;
	}
	public String getTelefoneFornecedor() {
		return telefoneFornecedor;
	}
	public void setTelefoneFornecedor(String telefoneFornecedor) {
		this.telefoneFornecedor = telefoneFornecedor;
	}
	
	public Endereco getEnderecoFornecedor() {
		return enderecoFornecedor;
	}
	public void setEnderecoFornecedor(Endereco enderecoFornecedor) {
		this.enderecoFornecedor = enderecoFornecedor;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(cnpjFornecedor);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Fornecedor other = (Fornecedor) obj;
		return Objects.equals(cnpjFornecedor, other.cnpjFornecedor);
	}
	@Override
	public String toString() {
		return "Fornecedor [id="+ fornecedorID + ", nomeFornecedor=" + nomeFornecedor + ", cnpjFornecedor=" + cnpjFornecedor
				+ ", emailFornecedor=" + emailFornecedor + ", telefoneFornecedor=" + telefoneFornecedor
				+ ", enderecoFornecedor=" + enderecoFornecedor + "]";
	}
	
}
