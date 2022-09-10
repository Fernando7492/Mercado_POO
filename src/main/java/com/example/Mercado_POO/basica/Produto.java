package com.example.Mercado_POO.basica;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class Produto{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String categoria;
	private BigDecimal valorCompra;
	private BigDecimal valorVenda;
	private int quantidade;
	private Date validade;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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
	public long getId() {
		return id;
	}
	public Produto(String name, String categoria, BigDecimal valorCompra, BigDecimal valorVenda, int quantidade,
			Date validade) {
		super();
		this.name = name;
		this.categoria = categoria;
		this.valorCompra = valorCompra;
		this.valorVenda = valorVenda;
		this.quantidade = quantidade;
		this.validade = validade;
	}
	
	
}
