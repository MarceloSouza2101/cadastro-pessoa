package br.com.mssantos.cadastropessoa.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TB_PESSOA_FISICA", schema = "pessoafisica")
public class PessoaFisicaEntity implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ID")
	private Long id;
	
	@Column(name = "CPF")
	private String cpf;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "ID_PROFISSAO")
	private Long idProfissao;
	
	@Column(name = "ID_GENERO")
	private Long idGenero;
	
	@Column(name = "NOME_MAE")
	private String nomeMae;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Long getIdGenero() {
		return idGenero;
	}

	public void setIdGenero(Long idGenero) {
		this.idGenero = idGenero;
	}

	public String getNomeMae() {
		return nomeMae;
	}

	public void setNomeMae(String nomeMae) {
		this.nomeMae = nomeMae;
	}
	
	

}
