package br.com.victorreis.eleve.config;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
/**Classe exclusiva para perfil de test */

import br.com.victorreis.eleve.model.Usuario;
import br.com.victorreis.eleve.repository.UsuarioRepository;


@Profile("test")
@Configuration
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		usuarioRepository.saveAll(Arrays.asList(u1,u2));
	}

}
