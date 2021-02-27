package br.com.victorreis.eleve.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorreis.eleve.model.Produto;
import br.com.victorreis.eleve.repository.ProdutoRepository;

@Service
public class ProdutoService {

	@Autowired
	private ProdutoRepository produtoRepository;

	public List<Produto> findAll() {
		return produtoRepository.findAll();
	}

	public Produto findById(Long id) {
		Optional<Produto> optional = produtoRepository.findById(id);
		// TODO implemetar execeção
		return optional.get();
	}

}
