package com.generation.gameverse.model;

import java.time.LocalDateTime;
import java.util.List;

import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_categorias")
public class Categoria {

	@Id // Primary Key
	@GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
	private Long id;
		
	@Column(length = 100)
	@NotBlank(message = "O atributo nome é obrigatório!")
	@Size(max = 100, message = "O atributo nome deve ter no minimo 5 e no máximo 100 caracteres.")
	@Pattern(regexp = "^[^0-9].*", message = "O nome não pode ser apenas numérico")
	private String nome;
	
	@Column(length = 1000)
	@NotBlank(message = "O atributo descricao é obrigatório!")
	@Size(min = 10, max = 1000, message = "O atributo descricao deve ter no minimo 10 e no máximo 1000 caracteres.")
	@Pattern(regexp = "^[^0-9].*", message = "O descricao não pode ser apenas numérico")
	private String descricao;
	
	@UpdateTimestamp
	private LocalDateTime data;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria", cascade = CascadeType.REMOVE)
	@JsonIgnoreProperties("categoria")
	private List<Produto> produto;
	
	public List<Produto> getProduto() {
		return produto;
	}
	public void setPostagem(List<Produto> produto) {
		this.produto = produto;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public LocalDateTime getData() {
		return data;
	}

	public void setData(LocalDateTime data) {
		this.data = data;
	}

}