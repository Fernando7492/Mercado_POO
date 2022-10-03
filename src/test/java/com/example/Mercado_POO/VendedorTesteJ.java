package com.example.Mercado_POO;

import static org.junit.jupiter.api.Assertions.*;

import org.assertj.core.api.Assertions;
//import org.junit.Rule;
import org.junit.jupiter.api.Test;
//import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.Mercado_POO.basica.Endereco;
import com.example.Mercado_POO.basica.Vendedor;
import com.example.Mercado_POO.fachada.Mercado;

@SpringBootTest
class VendedorTesteJ {
		
		@Autowired
		private Mercado mercado;
		
		/*@Rule
		public ExpectedException thrown = ExpectedException.none();
		
		@Test
		public void criacaoVendedorDevePersistir() {
			Endereco endereco = new Endereco("abc", "BR", "Garanhuns", "Cohab 1", "123", "55299437");
			Vendedor vendedor = new Vendedor("Marcos", "552.900.347-72", "M", "16/02/2000", "MarcosVendas@Email.com", endereco,
					"Vendedor", (double) 1550, "20/02/20020");
			this.mercado.saveVendedor(vendedor);
			Assertions.assertThat(vendedor.getId()).isNotNull();
			Assertions.assertThat(vendedor.getNome()).isEqualTo("Marcos");
			Assertions.assertThat(vendedor.getCpf()).isEqualTo("552.900.347-72");
			Assertions.assertThat(vendedor.getSalario()).isEqualTo(1550);
			Assertions.assertThat(vendedor.getEnderecoPessoa()).isEqualTo(endereco);
		}
*/
	}
