package br.com.victorreis.eleve.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorreis.eleve.model.Categoria;
import br.com.victorreis.eleve.repository.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> findAll() {
		return categoriaRepository.findAll();
	}

	public Categoria findById(Long id) {
		Optional<Categoria> optional = categoriaRepository.findById(id);
		// TODO implemetar execeção
		return optional.get();
	}

}
