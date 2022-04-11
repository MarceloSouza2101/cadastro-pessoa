package br.com.mssantos.cadastropessoa.vo;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class PessoaFisicaVO implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long idPessoaFisica;
	@NotNull(message = "É necessario digitar o CPF")
	@Size(max = 11, message = "CPF não pode ter mais de 11 dígitos")
	private String cpf;
	@NotNull(message = "É necessario digitar o nome")
	@Size(max = 150, message = "Nome não pode ter mais de 150 caracteres")
	private String nome;
	@NotNull(message = "É necessario digitar a profissão")
	private Long idProfissao;
	@NotNull(message = "É necessario digitar o nome da mãe")
	@Size(max = 150, message = "Nome não pode ter mais de 150 caracteres")
	private String nomeMae;
	@NotNull(message = "É necessario digitar o genero")
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
