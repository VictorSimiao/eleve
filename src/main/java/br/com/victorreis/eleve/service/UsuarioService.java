package br.com.victorreis.eleve.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorreis.eleve.model.Usuario;
import br.com.victorreis.eleve.repository.UsuarioRepository;
import br.com.victorreis.eleve.service.exception.RecursoNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	public List<Usuario> findAll() {
		return usuarioRepository.findAll();
	}

	public Usuario findById(Long id) {
		Optional<Usuario> optional = usuarioRepository.findById(id);
		return optional.orElseThrow(() -> new RecursoNotFoundException(id));
	}
	
	public Usuario save(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	
	public void deletar(Long id) {
		usuarioRepository.deleteById(id);
		// TODO implemetar execeção
	}
	
	public Usuario atualizar(Long id, Usuario usuarioRequest) {
		Usuario usuarioDB = usuarioRepository.getOne(id);
		atualizarDados(usuarioDB,usuarioRequest);
		return usuarioRepository.save(usuarioDB);
	}

	private void atualizarDados(Usuario usuarioDB, Usuario usuarioRequest) {
		usuarioDB.setNome(usuarioRequest.getNome());
		usuarioDB.setEmail(usuarioRequest.getEmail());
		usuarioDB.setTelefone(usuarioRequest.getTelefone());
	}

}
