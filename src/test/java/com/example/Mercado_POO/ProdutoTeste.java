package com.example.Mercado_POO;

import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Mercado_POO.basica.Produto;
import com.example.Mercado_POO.basica.ProdutoVenda;
import com.example.Mercado_POO.excecoes.QuantidadeNegativaException;

//@RunWith(SpringRunner.class)
@SpringBootTest
class ProdutoTeste {

	private Produto produto;
	private ProdutoVenda produtoVenda;
	int qtd;
	@Test
	void testaSetQuantidadeNegativa() {
		
	boolean thrown = false;
	produto = new Produto("produto1", "generico", 10.0, 15.0, 5, "01/02/2022");
	
	try {
		produtoVenda.setQtdProdutos(-1);		
	
	}   catch (QuantidadeNegativaException e) {
	    thrown = true;
	}
	
	  assertTrue(thrown);		
	}

}
