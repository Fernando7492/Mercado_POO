package com.example.Mercado_POO.basica;

import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;

@MappedSuperclass
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String nome;
	private String cpf;
	private String sexo;
	private String dataNascimento;
	private String email;
	
	@OneToOne//(cascade=CascadeType.ALL)
	private Endereco enderecoPessoa;

	public Pessoa(String nome, String cpf, String sexo, String dataNascimento, String email,
			Endereco enderecoPessoa) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.enderecoPessoa = enderecoPessoa;
	}

	
	public Pessoa(Long id, String nome, String cpf, String sexo, String dataNascimento, String email,
			Endereco enderecoPessoa) {
		super();
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.sexo = sexo;
		this.dataNascimento = dataNascimento;
		this.email = email;
		this.enderecoPessoa = enderecoPessoa;
	}


	public Pessoa() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEnderecoPessoa() {
		return enderecoPessoa;
	}

	public void setEnderecoPessoa(Endereco enderecoPessoa) {
		this.enderecoPessoa = enderecoPessoa;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		return Objects.equals(cpf, other.cpf);
	}

	@Override
	public String toString() {
		return "Pessoa [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", sexo=" + sexo + ", dataNascimento="
				+ dataNascimento + ", email=" + email + ", enderecoPessoa=" + enderecoPessoa + "]";
	}
	
}
