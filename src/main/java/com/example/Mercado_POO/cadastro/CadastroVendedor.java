package com.example.Mercado_POO.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mercado_POO.basica.Vendedor;
import com.example.Mercado_POO.repositorio.RepositorioVendedor;

@Service
public class CadastroVendedor {

	@Autowired
	private RepositorioVendedor repositorioVendedor;
	
	public Vendedor save(Vendedor vendedor) {
		if(repositorioVendedor.existsByCpf(vendedor.getCpf())) {
			return null;
		}	
		else {
			return repositorioVendedor.save(vendedor);
		}
	}
	
	public List<Vendedor> listAll(){
		return repositorioVendedor.findAll();
	}
	
	public Vendedor update( Vendedor novo) {
		
			return repositorioVendedor.save(novo);
		
	}
	
	public Optional<Vendedor> findById(Long id) {
		return repositorioVendedor.findById(id);
	}
	
	public Optional<Vendedor> findByNomeVendedor(String nome){
		return repositorioVendedor.findByNomeContainingIgnoreCase(nome);
	}
	
	public Optional<Vendedor> findByCpfVendedor(String cnpj) {
		return repositorioVendedor.findByCpfContainingIgnoreCase(cnpj);
	}
	
	public void deleteById(Long id) {
		repositorioVendedor.deleteById(id);
	}
	
	public void delete(Vendedor vendedor) {
		repositorioVendedor.delete(vendedor);
	}
}
