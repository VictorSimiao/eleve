package br.com.victorreis.eleve.service.exception;

public class RecursoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public RecursoNotFoundException(Object id) {
		super("Não encontrado o recurso com o ID " + id);
	}
}
