package com.example.Mercado_POO;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
//import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.Mercado_POO.basica.Endereco;
import com.example.Mercado_POO.basica.Fornecedor;
import com.example.Mercado_POO.fachada.Mercado;

//@RunWith(SpringRunner.class)
@SpringBootTest
class FornecedorTeste {
	
	@Autowired
	private Mercado mercado;
	
	@Test
	void testaCriarFornecedorRepetido() {
		Endereco end = new Endereco("rua a", "pe", "brejao", "centro", "79", "55325-000");
		
		Fornecedor forn = new Fornecedor("Fornecedor1", "123456", "forn@forn.com", "99999-9999", end);
		Fornecedor forn2 = new Fornecedor("Fornecedor2", "123456", "forn2@forn.com", "91111-1111", end);
		
		mercado.saveFornecedor(forn);
		assertNull(mercado.saveFornecedor(forn2));
	}

}
