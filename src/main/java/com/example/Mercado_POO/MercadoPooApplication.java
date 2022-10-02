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
		
		/*Mercado mercado = conf.getBean(Mercado.class);


		Endereco end = new Endereco("rua a", "pe", "brejao", "centro", "79", "55325-000");

		Vendedor vend = new Vendedor("pedroh","12345","m",new Date(0), "email@mail.com",end);

		Cliente cli = new Cliente("pedrog","12345","m",new Date(0), "email@mail.com",end);

		Produto prod = new Produto("prodduto1uj", "geral", new BigDecimal(10.0), new BigDecimal(15.0), 10, new Date(10));
		Produto prod2 = new Produto("prodfutoh2", "geral", new BigDecimal(10.0), new BigDecimal(15.0), 10, new Date(10));
		Produto prod3 = new Produto("produtg3", "geral", new BigDecimal(10.0), new BigDecimal(15.0), 10, new Date(10));
		
		ProdutoVenda prodvend = new ProdutoVenda(10, new Date(10), prod);
		ProdutoVenda prodvend2 = new ProdutoVenda(5, new Date(10), prod2);
		ProdutoVenda prodvend3 = new ProdutoVenda(1, new Date(10), prod3);

		List<ProdutoVenda> prods = new ArrayList();
		prods.add(prodvend);
		prods.add(prodvend2);
		prods.add(prodvend3);
		

		Venda venda = new Venda(1, LocalDateTime.now(),  new BigDecimal(15.0),"pix", cli, vend, prods);
		
		mercado.saveProduto(prod);
		mercado.saveProduto(prod2);
		mercado.saveProduto(prod3);
		mercado.saveVenda(venda);*/
		
		
	}

}
