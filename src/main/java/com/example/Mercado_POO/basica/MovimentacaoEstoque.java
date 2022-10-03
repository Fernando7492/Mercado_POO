package com.example.Mercado_POO.basica;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class MovimentacaoEstoque {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String dataHora;
	private String motivo;
	private Integer quantidade;

	@ManyToOne//(cascade = CascadeType.ALL)
	@JoinColumn(name="produto_id")
	private Produto produto;
	

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getDataHora() {
		return dataHora;
	}

	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}

	public String getMotivo() {
		return motivo;
	}

	public void setMotivo(String motivo) {
		this.motivo = motivo;
	}
	
	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public String toString() {
		return "MovimentacaoEstoque [id=" + id + ", dataHora=" + dataHora + ", motivo=" + motivo + ", produto="
				+ produto + "]";
	}

}
