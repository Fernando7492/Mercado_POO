package com.example.Mercado_POO.fachada;

import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mercado_POO.basica.Compra;
import com.example.Mercado_POO.basica.Fornecedor;
import com.example.Mercado_POO.basica.MovimentacaoEstoque;
import com.example.Mercado_POO.basica.Produto;
import com.example.Mercado_POO.basica.Venda;
import com.example.Mercado_POO.cadastro.CadastoMovimentacaoEstoque;
import com.example.Mercado_POO.cadastro.CadastroCompra;
import com.example.Mercado_POO.cadastro.CadastroFornecedor;
import com.example.Mercado_POO.cadastro.CadastroProduto;
import com.example.Mercado_POO.cadastro.CadastroVenda;

@Service
public class Mercado {

	@Autowired
	private CadastroFornecedor cadastroFornecedor;
	@Autowired
	private CadastroCompra cadastroCompra;
	@Autowired
	private CadastroVenda cadastroVenda;
	@Autowired
	private CadastroProduto cadastroProduto;
	@Autowired
	private CadastoMovimentacaoEstoque cadastroMovimentacaoEstoque;
	
	
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
	
	
	//Produto
	
	
	public Produto saveProduto(Produto produto) {
		return cadastroProduto.save(produto);
	}
	
	public Optional<Produto> findProdutoById(long id){
		return cadastroProduto.findById(id);
	}
	
	public List<Produto> listAllProduto(){
		return cadastroProduto.listAll();
	}
	
	public Produto updateProduto(Produto antigo,Produto novo) {
		novo.setId(antigo.getId());
		return cadastroProduto.save(novo);
	}
	
	public Optional<Produto> findByNomeProduto(String nome){
		return cadastroProduto.findByNomeProduto(nome);
	}
	
	public Optional<Produto> findByCategoriaProduto(String categoria){
		return cadastroProduto.findByCategoriaProduto(categoria);
	}
	
	public Optional<Produto> findByValidadeProduto(Date validadeProdutoMin,Date validadeProdutoMax){
		return cadastroProduto.findByValidadeProduto(validadeProdutoMin,validadeProdutoMax);
	} 
	
	public void deleteProdutoById(Long id) {
		cadastroProduto.deleteById(id);
	}
	
	public void deleteProduto(Produto produto) {
		cadastroProduto.delete(produto);
	}
	
	//Movimentacao Estoque
	
	public MovimentacaoEstoque saveMovimentacaoEstoque(MovimentacaoEstoque movimentacaoEstoque) {
		return cadastroMovimentacaoEstoque.save(movimentacaoEstoque);
	
	}	
	public Optional<MovimentacaoEstoque> findMovimentacaoEstoqueById(Long id){
		return cadastroMovimentacaoEstoque.findById(id);
	}
	public Optional<MovimentacaoEstoque> findByDataMovimentacaoEstoque(Date dataMovimentacaoEstoque){
		return cadastroMovimentacaoEstoque.findByDataMovimentacaoEstoque(dataMovimentacaoEstoque);
		
	}
	
	public Optional<MovimentacaoEstoque> findByHoraMovimentacaoEstoque(Time horaMovimentacaoEstoque) {
		return cadastroMovimentacaoEstoque.findByHoraMovimentacaoEstoque(horaMovimentacaoEstoque);
	}
	
	public Optional<MovimentacaoEstoque> findByMotivoMovimentacaoEstoque(String motivoMovimentacaoEstoque) {
		return cadastroMovimentacaoEstoque.findByMotivoMovimentacaoEstoque(motivoMovimentacaoEstoque);
	}
	

	
}
