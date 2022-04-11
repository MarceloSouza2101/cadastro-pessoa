package br.com.mssantos.cadastropessoa.exception;

public class ParametroInvalidoException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ParametroInvalidoException(String msg) {
		super(msg);
	}
}
