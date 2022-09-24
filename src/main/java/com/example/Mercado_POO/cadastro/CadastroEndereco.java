package com.example.Mercado_POO.cadastro;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mercado_POO.basica.Endereco;
import com.example.Mercado_POO.repositorio.RepositorioEndereco;

@Service
public class CadastroEndereco {
	
	@Autowired
	private RepositorioEndereco repositorioEndereco;
	
	public Endereco saveEndereco(Endereco endereco) {
		return repositorioEndereco.save(endereco);
	}
}
