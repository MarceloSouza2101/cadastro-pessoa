package br.com.mssantos.cadastropessoa.utils;

import org.slf4j.Logger;

import br.com.caelum.stella.validation.CPFValidator;
import br.com.mssantos.cadastropessoa.exception.ParametroInvalidoException;

public class VerificaCPFUtils {
	
	private VerificaCPFUtils() {}

	public static void verificaCPF(String cpf, Logger logger) throws ParametroInvalidoException {
		if (!new CPFValidator().invalidMessagesFor(cpf.trim().replaceAll("[.-]", "")).isEmpty()) {
			logger.error("CPF INFORMADO É INVALIDO: {}", cpf);
			throw new ParametroInvalidoException("CPF informado é inválido: " + cpf);
		}
		
	}
}
