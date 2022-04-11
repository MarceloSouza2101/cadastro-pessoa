package br.com.mssantos.cadastropessoa.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.mssantos.cadastropessoa.entity.PessoaFisicaEntity;

@Repository
public interface PessoaFisicaRepository extends PagingAndSortingRepository<PessoaFisicaEntity, Long>, JpaSpecificationExecutor<PessoaFisicaEntity>{

	Optional<PessoaFisicaEntity> findByCpf(String cpf);

}
