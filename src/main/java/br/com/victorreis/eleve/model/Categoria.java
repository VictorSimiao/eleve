package br.com.victorreis.eleve.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	private String nome;
	
	@JsonIgnore
	@ManyToMany(mappedBy = "categorias")
	private Set<Produto> produtos = new HashSet<>();

	public Categoria() {

	}

	public Categoria(Long id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	
	
	

}
