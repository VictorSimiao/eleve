package br.com.victorreis.eleve.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victorreis.eleve.model.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
