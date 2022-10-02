package com.example.Mercado_POO;

import java.sql.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.example.Mercado_POO.basica.Vendedor;
import com.example.Mercado_POO.basica.Endereco;
import com.example.Mercado_POO.fachada.Mercado;

@SpringBootApplication
public class MercadoPooApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext conf = SpringApplication.run(MercadoPooApplication.class, args);
		
		Mercado mercado = conf.getBean(Mercado.class);
		
		//Endereco end = new Endereco("rua a", "pe", "brejao", "centro", "79", "55325-000");
		
		//Vendedor vend = new Vendedor("pedro","12345","m",new Date(0), "email@mail.com",end);
		
		//mercado.saveVendedor(vend);
		
		
	}

}
