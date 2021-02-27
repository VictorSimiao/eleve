package br.com.victorreis.eleve.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.victorreis.eleve.model.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
