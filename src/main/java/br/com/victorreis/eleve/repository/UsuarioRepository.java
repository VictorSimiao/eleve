package br.com.victorreis.eleve.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victorreis.eleve.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
