package com.example.Mercado_POO;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Mercado_POO.basica.Produto;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProdutoTeste {

	private Produto produto;
	int qtd;
	@Test
	void testaSetQuantidadeNegativa() {
		
		produto = new Produto("produto1", "generico", new BigDecimal(10.0), new BigDecimal(15.0), 5, new Date(2025, 07, 25));
		qtd=produto.getQuantidade()-6;
		produto.setQuantidade(produto.getQuantidade()-6);
		assertNotEquals(qtd,produto.getQuantidade());
		
	}

}
