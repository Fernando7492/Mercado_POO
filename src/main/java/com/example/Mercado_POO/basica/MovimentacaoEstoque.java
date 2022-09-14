package com.example.Mercado_POO.basica;

import java.sql.Time;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class MovimentacaoEstoque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private Date data;
	private Time hora;
	private String motivo;
	@ManyToMany
	private Produto produto;
}
