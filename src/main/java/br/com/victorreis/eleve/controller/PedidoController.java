package br.com.victorreis.eleve.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.victorreis.eleve.model.Pedido;
import br.com.victorreis.eleve.service.PedidoService;

@RequestMapping("/pedidos")
@RestController
public class PedidoController {
	@Autowired
	private PedidoService pedidoService;

	@GetMapping
	public ResponseEntity<List<Pedido>> findAll() {
		List<Pedido> pedidos = pedidoService.findAll();
		return ResponseEntity.ok().body(pedidos);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Pedido> findById(@PathVariable Long id){
		Pedido pedido = pedidoService.findById(id);
		return ResponseEntity.ok().body(pedido);
	}

}
