package com.example.Mercado_POO.basica;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class ProdutoVenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private Integer qtdProdutos;
	private BigDecimal valorTotal;
	private Date validade;

	
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	public void calcularValorTotal() {
		valorTotal = produto.getValorVenda().multiply(new BigDecimal(qtdProdutos));
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQtdProdutos() {
		return qtdProdutos;
	}

	public void setQtdProdutos(Integer qtdProdutos) {
		this.qtdProdutos = qtdProdutos;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getValorTotal() {
		return valorTotal;
	}

	public Date getValidade() {
		return validade;
	}

	public ProdutoVenda(Integer qtdProdutos, Date validade, Produto produto) {
		super();
		this.qtdProdutos = qtdProdutos;
		this.produto = produto;
		this.validade = this.produto.getValidade();
	}

	@Override
	public String toString() {
		return "ProdutoVenda [qtdProdutos=" + qtdProdutos + ", valorTotal=" + valorTotal + ", validade=" + validade
				+ ", produto=" + produto + "]";
	}
	
}