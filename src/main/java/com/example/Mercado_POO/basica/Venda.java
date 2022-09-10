package com.example.Mercado_POO.basica;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

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
	private LocalDateTime dataHoraVenda;
	private BigDecimal valorTotalVenda;
	
	@ManyToOne
	@JoinColumn(name="cliente_id")
	private Cliente clienteVenda;
	
	@ManyToOne
	@JoinColumn(name="vendedor_id")
	private Vendedor vendedorVenda;
	
	@OneToMany
	@JoinColumn(name="venda_id")
	private List<ProdutoVenda> produtosVenda;
	
	private Venda() {
		super();
	}

	public Venda(LocalDateTime dataHoraVenda, BigDecimal valorTotalVenda,
			Cliente clienteVenda, Vendedor vendedorVenda, List<ProdutoVenda> produtosVenda) {
		super();
		this.dataHoraVenda = dataHoraVenda;
		this.valorTotalVenda = valorTotalVenda;
		this.clienteVenda = clienteVenda;
		this.vendedorVenda = vendedorVenda;
		this.produtosVenda = produtosVenda;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public LocalDateTime getDataHoraVenda() {
		return dataHoraVenda;
	}

	public void setDataHoraVenda(LocalDateTime dataHoraVenda) {
		this.dataHoraVenda = dataHoraVenda;
	}

	public BigDecimal getValorTotalVenda() {
		return valorTotalVenda;
	}

	public void setValorTotalVenda(BigDecimal valorTotalVenda) {
		this.valorTotalVenda = valorTotalVenda;
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
	}
	
	public void adicionarProduto(ProdutoVenda produto) {
		this.produtosVenda.add(produto);
	}
	
	public void removerProdutos(ProdutoVenda produto) {
		this.produtosVenda.remove(produto);

	}

	@Override
	public String toString() {
		return "Venda [id=" + id + ", dataHoraVenda=" + dataHoraVenda + ", valorTotalVenda="
				+ valorTotalVenda + ", clienteVenda=" + clienteVenda + ", vendedorVenda=" + vendedorVenda + "]";
	}
	
}
