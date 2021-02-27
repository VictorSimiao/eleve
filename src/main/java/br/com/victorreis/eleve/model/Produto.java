package br.com.victorreis.eleve.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
public class Produto {

	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	private String nome;

	private String descricao;

	private Double preco;

	private String urlImagem;
	
	@ManyToMany
	@JoinTable(name = "produto_categoria",
	joinColumns = @JoinColumn(name ="produto_id"),
	inverseJoinColumns = @JoinColumn(name = "categoria_Id"))
	private Set<Categoria> categorias = new HashSet<>();

	public Produto() {
	}

	public Produto(Long id, String nome, String descricao, Double preco, String urlImagem) {
		this.id = id;
		this.nome = nome;
		this.descricao = descricao;
		this.preco = preco;
		this.urlImagem = urlImagem;
	}

}
