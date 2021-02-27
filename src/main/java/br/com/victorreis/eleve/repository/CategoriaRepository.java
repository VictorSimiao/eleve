package br.com.victorreis.eleve.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victorreis.eleve.model.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {

}
