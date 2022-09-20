package com.example.Mercado_POO.basica;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;
//estudar annotation inheritance
@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private LocalDateTime dataHoraCompra;
	private BigDecimal valorTotalCompra;
	
	@ManyToOne
	@JoinColumn(name="fornecedor_id")
	private Fornecedor fornecedorCompra;

	@OneToMany
	@JoinColumn(name="compra_id")
	private List<ProdutoCompra> produtosCompra;
	
	private Compra() {
		super();
	}

	public Compra(LocalDateTime dataHoraCompra, BigDecimal valorTotalCompra,
			Fornecedor fornecedorCompra, List<ProdutoCompra> produtosCompra) {
		super();
		this.dataHoraCompra = dataHoraCompra;
		this.valorTotalCompra = valorTotalCompra;
		this.fornecedorCompra = fornecedorCompra;
		this.produtosCompra = produtosCompra;
	}

	public long getId() {
		return id;
	}

	public void setCodigoCompra(long id) {
		this.id = id;
	}

	public LocalDateTime getDataHoraCompra() {
		return dataHoraCompra;
	}

	public void setDataHoraCompra(LocalDateTime dataHoraCompra) {
		this.dataHoraCompra = dataHoraCompra;
	}

	public BigDecimal getValorTotalCompra() {
		return valorTotalCompra;
	}

	public Fornecedor getFornecedorCompra() {
		return fornecedorCompra;
	}

	public void setFornecedorCompra(Fornecedor fornecedorCompra) {
		this.fornecedorCompra = fornecedorCompra;
	}

	public List<ProdutoCompra> getProdutosCompra() {
		return produtosCompra;
	}

	public void setProdutosCompra(List<ProdutoCompra> produtosCompra) {
		this.produtosCompra = produtosCompra;
		calcularValor();
	}
	
	public void adicionarProduto(ProdutoCompra produto) {
		this.produtosCompra.add(produto);
		calcularValor();
	}
	
	public void removerProdutos(ProdutoCompra produto) {
		this.produtosCompra.remove(produto);
		calcularValor();
	}
	
	public void calcularValor() {
		for(ProdutoCompra produto:produtosCompra) {
			valorTotalCompra = produto.getValorTotal().add(valorTotalCompra);
		}
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", dataHoraCompra=" + dataHoraCompra + ", valorTotalCompra="
				+ valorTotalCompra + ", fornecedorCompra=" + fornecedorCompra + "]";
	}
	
}
