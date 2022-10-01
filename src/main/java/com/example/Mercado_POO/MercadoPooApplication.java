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
	}

}
