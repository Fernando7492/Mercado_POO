package com.example.Mercado_POO.basica;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vendedor extends Pessoa{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cargo;
	private double salario;
	private Date dataContrato;
	
	@OneToOne(cascade = CascadeType.ALL)
	private Pessoa pessoa;

	public Vendedor(Long id, String nome, String cpf, String sexo, Date dataNascimento, String email,
			Endereco enderecoPessoa, long id2, String cargo, double salario, Date dataContrato, Pessoa pessoa) {
		super(id, nome, cpf, sexo, dataNascimento, email, enderecoPessoa);
		id = id2;
		this.cargo = cargo;
		this.salario = salario;
		this.dataContrato = dataContrato;
		this.pessoa = pessoa;
	}

	public Vendedor(Long id, String nome, String cpf, String sexo, Date dataNascimento, String email,
			Endereco enderecoPessoa) {
		super(id, nome, cpf, sexo, dataNascimento, email, enderecoPessoa);
	}

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

	public Date getDataContrato() {
		return dataContrato;
	}

	public void setDataContrato(Date dataContrato) {
		this.dataContrato = dataContrato;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

	
	
}
