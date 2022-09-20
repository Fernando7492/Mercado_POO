package com.example.Mercado_POO.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mercado_POO.basica.Compra;
import com.example.Mercado_POO.repositorio.RepositorioCompra;

@Service
public class CadastroCompra {

	@Autowired
	private RepositorioCompra repositorioCompra;
	
	public Compra saveCompra(Compra compra) {
		return repositorioCompra.save(compra);
	}	
	
	public List<Compra> listAll(){
		return repositorioCompra.findAll();
	}
	
	public Optional<Compra> findById(Long id) {
		return repositorioCompra.findById(id);
	}
	
	public Optional<Compra> findByFornecedorCompraId(Long fornecedorId){
		return repositorioCompra.findByFornecedorCompraId(fornecedorId);	
	}
	
	public void deleteById(Long id) {
		repositorioCompra.deleteById(id);
	}
	
	public void delete(Compra compra) {
		repositorioCompra.delete(compra);
	}
}
