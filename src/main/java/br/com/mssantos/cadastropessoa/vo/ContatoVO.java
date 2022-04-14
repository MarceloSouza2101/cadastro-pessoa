package br.com.mssantos.cadastropessoa.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class ContatoVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idContato;
	@NotNull(message = "Necessario informar um id de pessoa fisica")
	private Long idPessoaFisica;
	@NotNull(message = "Necessario informar um telefone celular")
	@Size(max = 11, message = "Limite maximo: 11 digitos")
	private String telefoneCelular;
	private String email;
	private String observacaoContato;
	@NotNull(message = "Necessario informar flag email")
	private Boolean flagReceberEmail;
	@NotNull(message = "Necessario informar flag sms")
	private Boolean flagReceberSms;

	public Long getIdContato() {
		return idContato;
	}

	public void setIdContato(Long idContato) {
		this.idContato = idContato;
	}

	public Long getIdPessoaFisica() {
		return idPessoaFisica;
	}

	public void setIdPessoaFisica(Long idPessoaFisica) {
		this.idPessoaFisica = idPessoaFisica;
	}

	public String getTelefoneCelular() {
		return telefoneCelular;
	}

	public void setTelefoneCelular(String telefoneCelular) {
		this.telefoneCelular = telefoneCelular;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getObservacaoContato() {
		return observacaoContato;
	}

	public void setObservacaoContato(String observacaoContato) {
		this.observacaoContato = observacaoContato;
	}

	public Boolean getFlagReceberEmail() {
		return flagReceberEmail;
	}

	public void setFlagReceberEmail(Boolean flagReceberEmail) {
		this.flagReceberEmail = flagReceberEmail;
	}

	public Boolean getFlagReceberSms() {
		return flagReceberSms;
	}

	public void setFlagReceberSms(Boolean flagReceberSms) {
		this.flagReceberSms = flagReceberSms;
	}

}