package br.com.victorreis.eleve.config;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
/**Classe exclusiva para perfil de test */

import br.com.victorreis.eleve.model.Categoria;
import br.com.victorreis.eleve.model.ItemPedido;
import br.com.victorreis.eleve.model.Pagamento;
import br.com.victorreis.eleve.model.Pedido;
import br.com.victorreis.eleve.model.Produto;
import br.com.victorreis.eleve.model.Usuario;
import br.com.victorreis.eleve.model.enums.StatusPedido;
import br.com.victorreis.eleve.repository.CategoriaRepository;
import br.com.victorreis.eleve.repository.ItemPedidoRepository;
import br.com.victorreis.eleve.repository.PedidoRepository;
import br.com.victorreis.eleve.repository.ProdutoRepository;
import br.com.victorreis.eleve.repository.UsuarioRepository;


@Profile("test")
@Configuration
public class TestConfig implements CommandLineRunner{
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	@Autowired
	private PedidoRepository pedidoRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;
	@Autowired
	private ProdutoRepository produtoRepository;
	@Autowired
	private ItemPedidoRepository itemPedidoRepository;
	
	
	@Override
	public void run(String... args) throws Exception {
		
		Usuario u1 = new Usuario(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		Usuario u2 = new Usuario(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
		usuarioRepository.saveAll(Arrays.asList(u1,u2));
		
		
		
		Pedido p1 = new Pedido(null, Instant.parse("2019-06-20T19:53:07Z"),StatusPedido.PAGO, u1);
		Pedido p2 = new Pedido(null, Instant.parse("2019-07-21T03:42:10Z"),StatusPedido.AGUARDANDO_PAGAMENTO, u2);
		Pedido p3 = new Pedido(null, Instant.parse("2019-07-22T15:21:22Z"),StatusPedido.AGUARDANDO_PAGAMENTO, u1);
		pedidoRepository.saveAll(Arrays.asList(p1,p2,p3));
	
		
		
		Categoria cat1 = new Categoria(null, "Eletrônicos");
		Categoria cat2 = new Categoria(null, "Livros");
		Categoria cat3 = new Categoria(null, "Computadores");
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
		
		
		Produto pr1 = new Produto(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Produto pr2 = new Produto(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Produto pr3 = new Produto(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Produto pr4 = new Produto(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Produto pr5 = new Produto(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");
		produtoRepository.saveAll(Arrays.asList(pr1,pr2,pr3,pr4,pr5));
		
		//Associando produtos com suas categirias
		pr1.getCategorias().add(cat2);
		pr2.getCategorias().add(cat1);
		pr2.getCategorias().add(cat3);
		pr3.getCategorias().add(cat3);
		pr4.getCategorias().add(cat3);
		pr5.getCategorias().add(cat2);
		
		//Salvando os produtos com as associações
		produtoRepository.saveAll(Arrays.asList(pr1,pr2,pr3,pr4,pr5));
		
		//ItemPedido
		ItemPedido itemP1 = new ItemPedido(pr1, p1, 2, pr1.getPreco());
		ItemPedido itemP2 = new ItemPedido(pr3, p1, 1, pr3.getPreco());
		ItemPedido itemP3 = new ItemPedido(pr3, p2, 2, pr3.getPreco());
		ItemPedido itemP4 = new ItemPedido(pr5, p3, 2, pr5.getPreco());
		
		itemPedidoRepository.saveAll(Arrays.asList(itemP1,itemP2,itemP3,itemP4));
		
		//Pagamento
		Pagamento pagamento = new Pagamento(null, Instant.parse("2019-06-20T21:53:07Z"), p1);
		p1.setPagamento(pagamento);
		pedidoRepository.save(p1);
		
	}

}
