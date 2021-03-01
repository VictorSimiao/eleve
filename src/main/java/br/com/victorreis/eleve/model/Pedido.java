package br.com.victorreis.eleve.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import br.com.victorreis.eleve.model.enums.StatusPedido;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Setter
@Getter
@Entity
public class Pedido implements Serializable{

	private static final long serialVersionUID = 1L;

	@EqualsAndHashCode.Include
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss'Z'", timezone = "GMT")
	private Instant momentoDoPedido;

	private Integer statusPedido;

	@ManyToOne
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	@OneToMany(mappedBy = "id.pedido")
	private Set<ItemPedido> itens = new HashSet<>();
	
	

	public Pedido() {

	}

	public Pedido(Long id, Instant momentoDoPedido, StatusPedido statusPedido, Usuario usuario) {
		this.id = id;
		this.momentoDoPedido = momentoDoPedido;
		setStatusPedido(statusPedido);
		this.usuario = usuario;
	}

	// Bizu : Para ultilizar enum manualmente
	//O usuario passa o enum do StatusPedido(AGUARDANDO_PAGAMENTO,PAGO...)
	//Eu Pego o codigo deste enum (Integer) e salvo no banco
	public void setStatusPedido(StatusPedido statusPedido) {
		if (statusPedido != null) {
			this.statusPedido = statusPedido.getCodigo();
		}
	}
	//Pego o codigo do status pedido e transformo em um objeto StatusPedido
	public StatusPedido getStatusPedido() {
		return StatusPedido.valueOf(statusPedido);
	}

	

}
