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
	private String nomeProduto;
	private String categoriaProduto;
	private BigDecimal valorCompraProduto;
	private BigDecimal valorVendaProduto;
	private Integer quantidadeProduto;
	private Date validadeProduto;
	
	public String getNomeProduto() {
		return nomeProduto;
	}
	public void setNomeProduto(String nome) {
		this.nomeProduto = nome;
	}
	public String getCategoria() {
		return categoriaProduto;
	}
	public void setCategoria(String categoriaProduto) {
		this.categoriaProduto = categoriaProduto;
	}
	public BigDecimal getValorCompra() {
		return valorCompraProduto;
	}
	public void setValorCompra(BigDecimal valorCompra) {
		this.valorCompraProduto = valorCompra;
	}
	public BigDecimal getValorVenda() {
		return valorVendaProduto;
	}
	public void setValorVenda(BigDecimal valorVenda) {
		this.valorVendaProduto = valorVenda;
	}
	public int getQuantidade() {
		return quantidadeProduto;
	}
	public void setQuantidade(int quantidade) {
		if(quantidade<0) {
			this.quantidadeProduto=0;
		}else {
			this.quantidadeProduto = quantidade;
		}
	}
	public Date getValidade() {
		return validadeProduto;
	}
	public void setValidade(Date validade) {
		this.validadeProduto = validade;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getId() {
		return id;
	}
	public Produto(String nome, String categoria, BigDecimal valorCompra, BigDecimal valorVenda, int quantidade,
			Date validade) {
		super();
		this.nomeProduto = nome;
		this.categoriaProduto = categoria;
		this.valorCompraProduto = valorCompra;
		this.valorVendaProduto = valorVenda;
		this.quantidadeProduto = quantidade;
		this.validadeProduto = validade;
	}
	@Override
	public int hashCode() {
		return Objects.hash(categoriaProduto, id, nomeProduto, quantidadeProduto, validadeProduto, valorCompraProduto, valorVendaProduto);
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
		return Objects.equals(nomeProduto, other.nomeProduto);
	}
	@Override
	public String toString() {
		return "Produto [id=" + id + ", nome=" + nomeProduto + ", categoria=" + categoriaProduto + ", valorCompra=" + valorCompraProduto
				+ ", valorVenda=" + valorVendaProduto + ", quantidade=" + quantidadeProduto + ", validade=" + validadeProduto + "]";
	}	
}
