package br.com.victorreis.eleve.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.victorreis.eleve.model.Usuario;
import br.com.victorreis.eleve.service.UsuarioService;

@RequestMapping("/usuarios")
@RestController
public class UsuarioController {
	@Autowired
	private UsuarioService usuarioService;

	@GetMapping
	public ResponseEntity<List<Usuario>> findAll() {
		List<Usuario> usuarios = usuarioService.findAll();
		return ResponseEntity.ok().body(usuarios);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Usuario> findById(@PathVariable Long id){
		Usuario usuario = usuarioService.findById(id);
		return ResponseEntity.ok().body(usuario);
	}
	
	
	@PostMapping
	public ResponseEntity<Usuario> save(@RequestBody Usuario usuario,UriComponentsBuilder uriBuilder){
		usuario = usuarioService.save(usuario);
		URI uri = uriBuilder.path("/usuarios/{id}").buildAndExpand(usuario.getId()).toUri();
		return ResponseEntity.created(uri).body(usuario);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		usuarioService.deletar(id);
		return ResponseEntity.noContent().build();
	}

}
