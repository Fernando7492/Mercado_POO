package com.example.Mercado_POO.basica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ProdutoVenda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
}
