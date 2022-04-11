package br.com.mssantos.cadastropessoa.vo;

import java.io.Serializable;

public class PessoaFisicaFiltrosVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private Long idProfissao;
	private String cpf;
	
	public boolean isFiltrosInexistentes() {
	    return !incluiCpf() && !incluiIdProfissao() && !incluiNome(); 
	}
	
	public boolean incluiIdProfissao() {
		return this.idProfissao != null;
	}

	public boolean incluiCpf() {
		return this.cpf != null && !this.cpf.isBlank();
	}
	
	public boolean incluiNome() {
		return this.nome != null && !this.nome.isBlank();
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
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
}
