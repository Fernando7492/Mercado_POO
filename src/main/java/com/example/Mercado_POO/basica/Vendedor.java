package com.example.Mercado_POO.basica;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vendedor extends Pessoa{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String cargo;
	private double salario;
	private String dataContrato;

	
	public Vendedor(String nome, String cpf, String sexo, String dataNascimento, String email, Endereco enderecoPessoa,
			Long id, String cargo, double salario, String dataContrato) {
		super(nome, cpf, sexo, dataNascimento, email, enderecoPessoa);
		this.id = id;
		this.cargo = cargo;
		this.salario = salario;
		this.dataContrato = dataContrato;
	}

	
	public Vendedor(String nome, String cpf, String sexo, String dataNascimento, String email, Endereco enderecoPessoa,
			String cargo, double salario, String dataContrato) {
		super(nome, cpf, sexo, dataNascimento, email, enderecoPessoa);
		this.cargo = cargo;
		this.salario = salario;
		this.dataContrato = dataContrato;
	}

	

	

	public Vendedor() {
		super();
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

	public String getDataContrato() {
		return dataContrato;
	}

	public void setDataContrato(String dataContrato) {
		this.dataContrato = dataContrato;
	}

	@Override
	public String toString() {
		return "Vendedor [id=" + id + ", cargo=" + cargo + ", salario=" + salario + ", dataContrato=" + dataContrato
				+"]";
	}

}
