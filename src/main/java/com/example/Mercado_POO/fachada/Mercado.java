package com.example.Mercado_POO.fachada;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mercado_POO.basica.Compra;
import com.example.Mercado_POO.basica.Fornecedor;
import com.example.Mercado_POO.basica.Venda;
import com.example.Mercado_POO.cadastro.CadastroCompra;
import com.example.Mercado_POO.cadastro.CadastroFornecedor;
import com.example.Mercado_POO.cadastro.CadastroVenda;

@Service
public class Mercado {

	@Autowired
	private CadastroFornecedor cadastroFornecedor;
	@Autowired
	private CadastroCompra cadastroCompra;
	@Autowired
	private CadastroVenda cadastroVenda;
	
	
	public Fornecedor saveFornecedor(Fornecedor fornecedor) {
			return cadastroFornecedor.save(fornecedor);
	}
	
	public List<Fornecedor> listAllFornecedor(){
		return cadastroFornecedor.listAll();
	}
	
	public Fornecedor updateFornecedor(Fornecedor antigo, Fornecedor novo) {
		return cadastroFornecedor.update(antigo, novo);
	}
	
	public Optional<Fornecedor> findByIdFornecedor(Long id) {
		return cadastroFornecedor.findById(id);
	}
	
	public Optional<Fornecedor> findByNomeFornecedor(String nome){
		return cadastroFornecedor.findByNomeFornecedor(nome);
	}
	
	public Optional<Fornecedor> findByCnpjFornecedor(String cnpj) {
		return cadastroFornecedor.findByCnpjFornecedor(cnpj);
	}
	
	public void deleteByIdFornecedor(Long id) {
		cadastroFornecedor.deleteById(id);
	}
	
	public void deleteFornecedor(Fornecedor Fornecedor) {
		cadastroFornecedor.delete(Fornecedor);
	}

	
	
	public Compra saveCompra(Compra compra) {
		return cadastroCompra.save(compra);
	}	
	
	public List<Compra> listAllCompra(){
		return cadastroCompra.listAll();
	}
	
	public Optional<Compra> findByIdCompra(Long id) {
		return cadastroCompra.findById(id);
	}
	
	public Optional<Compra> findByFornecedorCompraId(Long fornecedorId){
		return cadastroCompra.findByFornecedorCompraId(fornecedorId);
	}
	
	public void deleteByIdCompra(Long id) {
		cadastroCompra.deleteById(id);
	}
	
	public void deleteCompra(Compra compra) {
		cadastroCompra.delete(compra);
	}
	
	
	
	public Venda saveVenda(Venda Venda) {
		return cadastroVenda.save(Venda);
	}	
	
	public List<Venda> listAllVenda(){
		return cadastroVenda.listAll();
	}
	
	public Optional<Venda> findByIdVenda(Long id) {
		return cadastroVenda.findById(id);
	}
	
	public Optional<Venda> findByClienteVendaId(Long fornecedorId){
		return cadastroVenda.findByClienteVendaId(fornecedorId);
	}
	
	public Optional<Venda> findByVendedorVendaId(Long fornecedorId){
		return cadastroVenda.findByVendedorVendaId(fornecedorId);
	}
	
	public void deleteByIdVenda(Long id) {
		cadastroVenda.deleteById(id);
	}
	
	public void deleteVenda(Venda Venda) {
		cadastroVenda.delete(Venda);
	}
	
}
