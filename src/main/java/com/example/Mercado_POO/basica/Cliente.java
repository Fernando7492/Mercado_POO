package com.example.Mercado_POO.basica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente extends Pessoa{
	
	public Cliente(Long id,String nome, String cpf, String sexo, String dataNascimento, String email,	Endereco enderecoPessoa) {
		super(id,nome, cpf, sexo, dataNascimento, email, enderecoPessoa);
	}
	
	public Cliente() {
		super();
	}
	
}
