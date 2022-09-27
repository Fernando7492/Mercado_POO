package com.example.Mercado_POO.basica;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Produto{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String nome;
	private String categoria;
	private BigDecimal valorCompra;
	private BigDecimal valorVenda;
	private Integer quantidade;
	private Date validade;
	
	public Produto(String nome, String categoria, BigDecimal valorCompra, BigDecimal valorVenda, int quantidade,
			Date validade) {
		super();
		this.nome = nome;
		this.categoria = categoria;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
		this.quantidade = quantidade;
		this.validade = validade;
	}
	
	
	
	public Produto(long id, String nome, String categoria, BigDecimal valorCompra, BigDecimal valorVenda,
			Integer quantidade, Date validade) {
		super();
		this.id = id;
		this.nome = nome;
		this.categoria = categoria;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
		this.quantidade = quantidade;
		this.validade = validade;
	}



	public Produto() {
		super();
	}



	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	public BigDecimal getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompra = valorCompra;
	}
	public BigDecimal getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVenda = valorVenda;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Date getValidade() {
		return validade;
	}
	public void setValidade(Date validade) {
		this.validade = validade;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(categoria, id, nome, quantidade, validade, valorCompra, valorVenda);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(categoria, other.categoria) && id == other.id && Objects.equals(nome, other.nome)
				&& quantidade == other.quantidade && Objects.equals(validade, other.validade)
				&& Objects.equals(valorCompra, other.valorCompra) && Objects.equals(valorVenda, other.valorVenda);
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nome + ", categoria=" + categoria + ", valorCompra=" + valorCompra
				+ ", valorVenda=" + valorVenda + ", quantidade=" + quantidade + ", validade=" + validade + "]";
	}	
}
