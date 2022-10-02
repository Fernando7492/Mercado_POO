package com.example.Mercado_POO.basica;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;


@Entity
public class ProdutoVenda {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Integer qtdProdutos;
	private Double valorTotal;
	private String validade;
	//Date String = new Date();
	
	@ManyToOne
	@JoinColumn(name="produto_id")
	private Produto produto;
	
	public ProdutoVenda(Integer qtdProdutos, String validade, Produto produto) {
		super();
		this.qtdProdutos = qtdProdutos;
		this.produto = produto;
		this.validade = this.produto.getValidade();
	}
	
	public ProdutoVenda(Integer qtdProdutos, Double valorTotal, String validade, Produto produto) {
		super();
		this.qtdProdutos = qtdProdutos;
		this.valorTotal = valorTotal;
		this.validade = validade;
		this.produto = produto;
	}

	
	public ProdutoVenda(Long id, Integer qtdProdutos, Double valorTotal, String validade, String String, Produto produto) {
		super();
		this.id = id;
		this.qtdProdutos = qtdProdutos;
		this.valorTotal = valorTotal;
		this.validade = validade;
		this.produto = produto;
	}

	public void calcularValorTotal() {
		valorTotal= produto.getValorVenda() * qtdProdutos;
		//valorTotal = produto.getValorVenda().multiply(new BigDecimal(qtdProdutos));
	}
	
	
	
	public ProdutoVenda() {
		super();
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

	public Double getValorTotal() {
		return valorTotal;
	}

	public String getValidade() {
		return validade;
	}

	

	@Override
	public String toString() {
		return "ProdutoVenda [qtdProdutos=" + qtdProdutos + ", valorTotal=" + valorTotal + ", validade=" + validade
				+ ", produto=" + produto + "]";
	}
	
}