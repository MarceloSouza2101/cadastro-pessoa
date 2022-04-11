package br.com.mssantos.cadastropessoa.vo;

import java.io.Serializable;

public class PessoaFisicaResumidaVO implements Serializable{

	private static final long serialVersionUID = 1L;

	private String nome;
	private Long idProfissao;
	private String cpf;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Long getIdProfissao() {
		return idProfissao;
	}
	public void setIdProfissao(Long idProfissao) {
		this.idProfissao = idProfissao;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	
	
	
}
