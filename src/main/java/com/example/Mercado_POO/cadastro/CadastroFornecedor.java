package com.example.Mercado_POO.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mercado_POO.basica.Fornecedor;
import com.example.Mercado_POO.repositorio.RepositorioFornecedor;

@Service
public class CadastroFornecedor {
	
	@Autowired
	private RepositorioFornecedor repositorioFornecedor;
	
	public Fornecedor save(Fornecedor fornecedor) {
		if(repositorioFornecedor.existsByCnpjFornecedor(fornecedor.getCnpjFornecedor())) {
			return null;
		}	
		else {
			return repositorioFornecedor.save(fornecedor);
		}
	}
	
	public List<Fornecedor> listAll(){
		return repositorioFornecedor.findAll();
	}
	
	public Fornecedor update(Fornecedor antigo, Fornecedor novo) {
		novo.setId(antigo.getId());
		return repositorioFornecedor.save(novo);
	}
	
	public Optional<Fornecedor> findById(Long id) {
		return repositorioFornecedor.findById(id);
	}
	
	public Optional<Fornecedor> findByNomeFornecedor(String nome){
		return repositorioFornecedor.findByNomeFornecedorContainingIgnoreCase(nome);
	}
	
	public Optional<Fornecedor> findByCnpjFornecedor(String cnpj) {
		return repositorioFornecedor.findByCnpjFornecedorContainingIgnoreCase(cnpj);
	}
	
	public void deleteById(Long id) {
		repositorioFornecedor.deleteById(id);
	}
	
	public void delete(Fornecedor Fornecedor) {
		repositorioFornecedor.delete(Fornecedor);
	}

}
