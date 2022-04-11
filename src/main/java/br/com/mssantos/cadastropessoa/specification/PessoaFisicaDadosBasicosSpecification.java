package br.com.mssantos.cadastropessoa.specification;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import br.com.mssantos.cadastropessoa.entity.PessoaFisicaEntity;
import br.com.mssantos.cadastropessoa.vo.PessoaFisicaFiltrosVO;

public class PessoaFisicaDadosBasicosSpecification implements Specification<PessoaFisicaEntity>{

private static final long serialVersionUID = 1L;
	
	private transient PessoaFisicaFiltrosVO filtros;
	
	public PessoaFisicaDadosBasicosSpecification(PessoaFisicaFiltrosVO filtros) {
		this.filtros = filtros;
	}

	@Override
	public Predicate toPredicate(Root<PessoaFisicaEntity> root, CriteriaQuery<?> query,
			CriteriaBuilder criteriaBuilder) {
		
		List<Predicate> condicoes = new ArrayList<>();
		
		if (filtros.incluiCpf()) {
			Predicate igualCpf = criteriaBuilder.equal(root.get("cpf"), filtros.getCpf());
			condicoes.add(igualCpf);
		}
		
		if (filtros.incluiNome()) {
			Predicate likeNome = criteriaBuilder.like(root.get("nome"), "%" + filtros.getNome() + "%");
			condicoes.add(likeNome);
		} 
		
		if (filtros.incluiIdProfissao()) {
			Predicate incluiIdProfissao = criteriaBuilder.equal(root.get("idProfissao"), filtros.getIdProfissao());
			condicoes.add(incluiIdProfissao);
		}
		
	    return criteriaBuilder.and(condicoes.toArray(new Predicate[0]));
	}
	
}
