package br.com.victorreis.eleve.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorreis.eleve.model.Usuario;
import br.com.victorreis.eleve.repository.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		// TODO implemetar execeção
		return optional.get();
	}
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}

}
