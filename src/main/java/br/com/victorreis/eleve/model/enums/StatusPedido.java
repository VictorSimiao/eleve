package br.com.victorreis.eleve.model.enums;

import lombok.Getter;

@Getter
public enum StatusPedido {
	AGUARDANDO_PAGAMENTO(1),
	PAGO(2),
	ENVIADO(3),
	ENTREGUE(4),
	CANCELADO(5);
	
	private Integer codigo;
	
	private StatusPedido(Integer codigo) {
		this.codigo = codigo;
	}
	
	//Passa um código e retorna um objeto StatusPedido
	public static StatusPedido valueOf(Integer codigo) {
		for (StatusPedido statusPedido : StatusPedido.values()) {
			if(statusPedido.getCodigo() == codigo) {
				return statusPedido;
			}
		}
		throw new IllegalArgumentException("Código de status do pedido inválido");
	}
	
}
