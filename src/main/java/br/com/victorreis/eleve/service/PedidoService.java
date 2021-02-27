package br.com.victorreis.eleve.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.victorreis.eleve.model.Pedido;
import br.com.victorreis.eleve.repository.PedidoRepository;

@Service
public class PedidoService {
	
	@Autowired
	private PedidoRepository pedidoRepository;
	
	public List<Pedido> findAll() {
		return pedidoRepository.findAll();
	}

	public Pedido findById(Long id) {
		Optional<Pedido> optional = pedidoRepository.findById(id);
		// TODO implemetar execeção
		return optional.get();
	}

}
