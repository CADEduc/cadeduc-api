package br.com.imd.cadeduc.criterio.exception;

import br.com.imd.cadwork.core.dao.GenericDomainException;

public class CriterioException extends GenericDomainException {

	private static final long serialVersionUID = 1L;

	public CriterioException() {
		super("Erro gerado pelo critério!");
	}
	
	public CriterioException(String message) {
		super(message);
	}
}
