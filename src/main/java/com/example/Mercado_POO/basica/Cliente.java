package com.example.Mercado_POO.basica;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cliente extends Pessoa{
	
	public Cliente(String nome, String cpf, String sexo, Date dataNascimento, String email,
			Endereco enderecoPessoa) {
		super(nome, cpf, sexo, dataNascimento, email, enderecoPessoa);
	}
	

}
