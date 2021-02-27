package br.com.victorreis.eleve.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
public class Usuario {
	
	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	
	private String nome;
	
	private String email;
	
	private String telefone;
	
	private String senha;
	
	@OneToMany(mappedBy = "usuario")
	@JsonIgnore
	private List<Pedido> pedidos = new ArrayList<>();
	

	public Usuario() {
	}

	public Usuario(Long id, String nome, String email, String telefone, String senha) {
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.telefone = telefone;
		this.senha = senha;
	}


}
