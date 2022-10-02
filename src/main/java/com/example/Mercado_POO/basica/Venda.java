package com.example.Mercado_POO.basica;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class Venda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime horaVenda;
	private BigDecimal valorTotal;
	private String formaPagamento;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="cliente_id")
	private Cliente clienteVenda;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="vendedor_id")
	private Vendedor vendedorVenda;
	
	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="venda_id")
	private List<ProdutoVenda> produtosVenda;
	
	private Venda() {
		super();
	}

	public Venda(LocalDateTime horaVenda, BigDecimal valorTotal, String formaPagamento,
			Cliente clienteVenda, Vendedor vendedorVenda, List<ProdutoVenda> produtosVenda) {
		super();
		this.horaVenda = horaVenda;
		this.valorTotal = valorTotal;
		this.formaPagamento = formaPagamento;
		this.clienteVenda = clienteVenda;
		this.vendedorVenda = vendedorVenda;
		this.produtosVenda = produtosVenda;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getHoraVenda() {
		return horaVenda;
	}

	public void setHoraVenda(LocalDateTime horaVenda) {
		this.horaVenda = horaVenda;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public Cliente getClienteVenda() {
		return clienteVenda;
	}

	public void setFornecedorVenda(Cliente clienteVenda) {
		this.clienteVenda = clienteVenda;
	}
	
	public Vendedor getVendedorVenda() {
		return vendedorVenda;
	}

	public void setVendedorVenda(Vendedor vendedorVenda) {
		this.vendedorVenda = vendedorVenda;
	}
	public List<ProdutoVenda> getProdutosVenda() {
		return produtosVenda;
	}

	public void setProdutosVenda(List<ProdutoVenda> produtosVenda) {
		this.produtosVenda = produtosVenda;
		calcularValor();
	}
	
	public void adicionarProduto(ProdutoVenda produto) {
		this.produtosVenda.add(produto);
		calcularValor();
	}
	
	public void removerProdutos(ProdutoVenda produto) {
		this.produtosVenda.remove(produto);
		calcularValor();
	}
	
	public void calcularValor() {
		for(ProdutoVenda produto: produtosVenda) {
			valorTotal = produto.getValorTotal().add(valorTotal);
		}
	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", dataHoraVenda=" + horaVenda + ", valorTotalVenda="
				+ valorTotal + ", clienteVenda=" + clienteVenda + ", vendedorVenda=" + vendedorVenda + "]";
	}
	
}
