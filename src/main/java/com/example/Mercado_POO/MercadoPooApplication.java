package com.example.Mercado_POO;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.Mercado_POO.basica.Vendedor;
import com.example.Mercado_POO.basica.Cliente;
import com.example.Mercado_POO.basica.Endereco;
import com.example.Mercado_POO.basica.Produto;
import com.example.Mercado_POO.basica.ProdutoVenda;
import com.example.Mercado_POO.basica.Venda;
import com.example.Mercado_POO.fachada.Mercado;

@SpringBootApplication
public class MercadoPooApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext conf = SpringApplication.run(MercadoPooApplication.class, args);
		
		Mercado mercado = conf.getBean(Mercado.class);
		
		Endereco end = new Endereco("rua a", "pe", "brejao", "centro", "79", "55325-000");
		
		Vendedor vend = new Vendedor("pedro","12345","m",new Date(0), "email@mail.com",end);
		
		Cliente cli = new Cliente("pedro","12345","m",new Date(0), "email@mail.com",end);
		
		Produto prod = new Produto("produto1", "geral", new BigDecimal(10.0), new BigDecimal(15.0), 1, new Date(10));
		
		ProdutoVenda prodvend = new ProdutoVenda(1, new Date(10), prod);
		
		List<ProdutoVenda> prods = new ArrayList();
		prods.add(prodvend);
		
		Venda venda = new Venda(LocalDateTime.now(),  new BigDecimal(15.0), cli, vend, prods);
		
		//mercado.saveCliente(cli);
		//mercado.saveVendedor(vend);
		
		//mercado.saveVenda(venda);
		
		
	}

}
