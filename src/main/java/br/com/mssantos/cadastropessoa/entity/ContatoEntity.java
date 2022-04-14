package br.com.mssantos.cadastropessoa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_CDA_CONTATO_PESSOA_FISICA", schema = "pessoafisica")
public class ContatoEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;

	@Column(name = "ID_PESSOA_FISICA", nullable = false, unique = true)
	private Long idPessoaFisica;

	@Column(name = "NUM_CELULAR", nullable = false)
	private String telefoneCelular;

	@Column(name = "EMAIL", nullable = false)
	private String email;

	@Column(name = "DESC_OBS_CONTATO")
	private String observacaoContato;

	@Column(name = "FLAG_EMAIL", nullable = false)
	private Boolean flagEmail;

	@Column(name = "FLAG_SMS", nullable = false)
	private Boolean flagSms;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Boolean getFlagEmail() {
		return flagEmail;
	}

	public void setFlagEmail(Boolean flagEmail) {
		this.flagEmail = flagEmail;
	}

	public Boolean getFlagSms() {
		return flagSms;
	}

	public void setFlagSms(Boolean flagSms) {
		this.flagSms = flagSms;
	}

	
}
