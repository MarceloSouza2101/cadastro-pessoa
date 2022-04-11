package br.com.mssantos.cadastropessoa.vo;

import java.io.Serializable;

public class PessoaFisicaVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idPessoaFisica;
	private String cpf;
	private String nome;
	private Long idProfissao;
	private String nomeMae;
	private Long idGenero;
	
	public Long getIdPessoaFisica() {
		return idPessoaFisica;
	}
	public void setIdPessoaFisica(Long idPessoaFisica) {
		this.idPessoaFisica = idPessoaFisica;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
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
	public String getNomeMae() {
		return nomeMae;
	}
	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	public Long getIdGenero() {
		return idGenero;
	}
	public void setIdGenero(Long idGenero) {
		this.idGenero = idGenero;
	}

}
