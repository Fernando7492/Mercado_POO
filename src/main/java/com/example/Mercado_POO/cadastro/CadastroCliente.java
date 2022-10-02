package com.example.Mercado_POO.cadastro;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mercado_POO.basica.Cliente;
import com.example.Mercado_POO.repositorio.RepositorioCliente;

@Service
public class CadastroCliente {

	@Autowired
	private RepositorioCliente repositorioCliente;
	
	public Cliente save(Cliente cliente) {
		if(repositorioCliente.existsByCpf(cliente.getCpf())) {
			return null;
		}	
		else {
			return repositorioCliente.save(cliente);
		}
	}
	
	public List<Cliente> listAll(){
		return repositorioCliente.findAll();
	}
	
	public Cliente update(long antigoId, Cliente novo) {
		if(repositorioCliente.existsByCpf(novo.getCpf())) {
			return null;
		}	
		else {
			novo.setId(antigoId);
			return repositorioCliente.save(novo);
		}
	}
	
	public Optional<Cliente> findById(Long id) {
		return repositorioCliente.findById(id);
	}
	
	public Optional<Cliente> findByNomeCliente(String nome){
		return repositorioCliente.findByNomeContainingIgnoreCase(nome);
	}
	
	public Optional<Cliente> findByCpfCliente(String cnpj) {
		return repositorioCliente.findByCpfContainingIgnoreCase(cnpj);
	}
	
	public void deleteById(Long id) {
		repositorioCliente.deleteById(id);
	}
	
	public void delete(Cliente cliente) {
		repositorioCliente.delete(cliente);
	}
	
}
