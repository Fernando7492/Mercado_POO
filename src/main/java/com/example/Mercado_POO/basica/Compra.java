package com.example.Mercado_POO.basica;

import java.util.List;

import javax.persistence.*;

@Entity
public class Compra {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String horaCompra;
	private Double valorTotalCompra;
	
	@ManyToOne
	@JoinColumn(name="fornecedor_id")
	private Fornecedor fornecedorCompra;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name="compra_id")
	private List<ProdutoCompra> produtosCompra;
	
	private Compra() {
		super();
	}

	public Compra(String horaCompra, Double valorTotalCompra,
			Fornecedor fornecedorCompra, List<ProdutoCompra> produtosCompra) {
		super();
		this.horaCompra = horaCompra;
		this.valorTotalCompra = valorTotalCompra;
		this.fornecedorCompra = fornecedorCompra;
		this.produtosCompra = produtosCompra;
	}

	public Long getId() {
		return id;
	}

	public void setCodigoCompra(long id) {
		this.id = id;
	}

	public String getDataHoraCompra() {
		return horaCompra;
	}

	public void setDataHoraCompra(String horaCompra) {
		this.horaCompra = horaCompra;
	}

	public Double getValorTotalCompra() {
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
	
	public void calcularValor() {
		for(ProdutoCompra produto:produtosCompra) {
			valorTotalCompra = produto.getValorTotal()+valorTotalCompra;
		}
	}

	@Override
	public String toString() {
		return "Compra [id=" + id + ", dataHoraCompra=" + horaCompra + ", valorTotalCompra="
				+ valorTotalCompra + ", fornecedorCompra=" + fornecedorCompra + "]";
	}
	
}
