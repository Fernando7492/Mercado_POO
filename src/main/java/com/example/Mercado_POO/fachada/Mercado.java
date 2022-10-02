package com.example.Mercado_POO.fachada;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Mercado_POO.basica.Cliente;
import com.example.Mercado_POO.basica.Compra;
import com.example.Mercado_POO.basica.Fornecedor;
import com.example.Mercado_POO.basica.MovimentacaoEstoque;
import com.example.Mercado_POO.basica.Produto;
import com.example.Mercado_POO.basica.ProdutoCompra;
import com.example.Mercado_POO.basica.ProdutoVenda;
import com.example.Mercado_POO.basica.Venda;
import com.example.Mercado_POO.basica.Vendedor;
import com.example.Mercado_POO.cadastro.CadastoMovimentacaoEstoque;
import com.example.Mercado_POO.cadastro.CadastroCliente;
import com.example.Mercado_POO.cadastro.CadastroCompra;
import com.example.Mercado_POO.cadastro.CadastroFornecedor;
import com.example.Mercado_POO.cadastro.CadastroProduto;
import com.example.Mercado_POO.cadastro.CadastroVenda;
import com.example.Mercado_POO.cadastro.CadastroVendedor;

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
	@Autowired
	private CadastroCliente cadastroCliente;
	@Autowired
	private CadastroVendedor cadastroVendedor;
	
	//Fornecedor
	
	public Fornecedor saveFornecedor(Fornecedor fornecedor) {
			return cadastroFornecedor.save(fornecedor);
	}
	
	public List<Fornecedor> listAllFornecedor(){
		return cadastroFornecedor.listAll();
	}
	
	public Fornecedor updateFornecedor( Fornecedor novo) {
		return cadastroFornecedor.update( novo);
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
	
	public void deleteFornecedor(Fornecedor fornecedor) {
		cadastroFornecedor.delete(fornecedor);
	}

	//Compra
	
	public Compra saveCompra(Compra compra) {
		for(ProdutoCompra produto : compra.getProdutosCompra()) {
			produto.getProduto().setQuantidade((produto.getProduto().getQuantidade())+produto.getQtdProdutos());
			MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
			movimentacao.setProduto(produto.getProduto());
			movimentacao.setQuantidade(+produto.getQtdProdutos());
			movimentacao.setMotivo("Compra");
			movimentacao.setDataHora("1/8/2022");
			saveMovimentacaoEstoque(movimentacao);
		}
		return cadastroCompra.saveCompra(compra);
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
	
	//Venda
	
	public Venda saveVenda(Venda venda) {
		boolean done = true;
		ArrayList<ProdutoVenda> listProdutoVenda = new ArrayList<ProdutoVenda>(venda.getProdutosVenda());
		ArrayList<Produto> listProduto = new ArrayList<Produto>(listAllProduto());
			
		for(ProdutoVenda produtoVenda : listProdutoVenda) {
			for(Produto produto : listProduto) {
				if(produtoVenda.getProduto().getId()==produto.getId()) {
					if(produtoVenda.getQtdProdutos() <= produto.getQuantidade()) {
						produto.setQuantidade(produto.getQuantidade()-produtoVenda.getQtdProdutos());
					}else {
						done = false;
					}
				}
			}
		}
		
		if(done) {
			for(ProdutoVenda produto : venda.getProdutosVenda()) {
			produto.getProduto().setQuantidade((produto.getProduto().getQuantidade())-produto.getQtdProdutos());
			MovimentacaoEstoque movimentacao = new MovimentacaoEstoque();
			movimentacao.setProduto(produto.getProduto());
			movimentacao.setQuantidade(-produto.getQtdProdutos());
			movimentacao.setMotivo("Venda");
			movimentacao.setDataHora(venda.getHoraVenda());
			saveMovimentacaoEstoque(movimentacao);
			}
			return cadastroVenda.saveVenda(venda);
		}else {
			return null;
		}
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
	
	public Produto updateProduto(long antigoId,Produto novo) {
			return cadastroProduto.update(antigoId,novo);
	}
	
	public Optional<Produto> findByNomeProduto(String nome){
		return cadastroProduto.findByNome(nome);
	}
	
	public Optional<Produto> findByCategoriaProduto(String categoria){
		return cadastroProduto.findByCategoria(categoria);
	}
	
	public Optional<Produto> findByValidadeProduto(Date validadeProdutoMin,Date validadeProdutoMax){
		return cadastroProduto.findByValidade(validadeProdutoMin,validadeProdutoMax);
	} 
	
	public void deleteProdutoById(Long id) {
		cadastroProduto.deleteById(id);
	}
	
	public void deleteProduto(Produto produto) {
		cadastroProduto.delete(produto);
	}
	
	//MovimentacaoEstoque
	
	public MovimentacaoEstoque saveMovimentacaoEstoque(MovimentacaoEstoque movimentacaoEstoque) {
		return cadastroMovimentacaoEstoque.saveMovimentacaoEstoque(movimentacaoEstoque);
	}	
	public Optional<MovimentacaoEstoque> findMovimentacaoEstoqueById(Long id){
		return cadastroMovimentacaoEstoque.findById(id);
	}
	public Optional<MovimentacaoEstoque> findByDataMovimentacaoEstoque(String dataMovimentacaoEstoqueIni, String dataMovimentacaoEstoqueFim){
		return cadastroMovimentacaoEstoque.findByDataHora(dataMovimentacaoEstoqueIni, dataMovimentacaoEstoqueFim);

	}
	

	//Cliente
	
	public Cliente saveCliente(Cliente cliente) {
		return cadastroCliente.save(cliente);
	}
	
	public List<Cliente> listAllCliente(){
		return cadastroCliente.listAll();
	}
	
	public Cliente updateCliente(long antigoId, Cliente novo) {
		return cadastroCliente.update(antigoId, novo);
	}
	
	public Optional<Cliente> findByIdCliente(Long id) {
		return cadastroCliente.findById(id);
	}
	
	public Optional<Cliente> findByNomeCliente(String nome){
		return cadastroCliente.findByNomeCliente(nome);
	}
	
	public Optional<Cliente> findByCpfCliente(String cpf) {
		return cadastroCliente.findByCpfCliente(cpf);
	}
	
	public void deleteByIdCliente(Long id) {
		cadastroCliente.deleteById(id);
	}
	
	public void deleteCliente(Cliente cliente) {
		cadastroCliente.delete(cliente);
	}
	
	//Vendedor

	public Vendedor saveVendedor(Vendedor vendedor) {
		return cadastroVendedor.save(vendedor);
	}
	
	public List<Vendedor> listAllVendedor(){
		return cadastroVendedor.listAll();
	}
	
	public Vendedor updateVendedor(long antigoId, Vendedor novo) {
		return cadastroVendedor.update(antigoId, novo);
	}
	
	public Optional<Vendedor> findByIdVendedor(Long id) {
		return cadastroVendedor.findById(id);
	}
	
	public Optional<Vendedor> findByNomeVendedor(String nome){
		return cadastroVendedor.findByNomeVendedor(nome);
	}
	
	public Optional<Vendedor> findByCpfVendedor(String cpf) {
		return cadastroVendedor.findByCpfVendedor(cpf);
	}
	
	public void deleteByIdVendedor(Long id) {
		cadastroVendedor.deleteById(id);
	}
	
	public void deleteVendedor(Vendedor vendedor) {
		cadastroVendedor.delete(vendedor);
	}
	
}
