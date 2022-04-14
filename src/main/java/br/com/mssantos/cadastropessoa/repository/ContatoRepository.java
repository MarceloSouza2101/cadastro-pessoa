package br.com.mssantos.cadastropessoa.repository;

import java.util.Optional;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.mssantos.cadastropessoa.entity.ContatoEntity;

@Repository
public interface ContatoRepository extends PagingAndSortingRepository<ContatoEntity, Long>{

	Optional<ContatoEntity> findByIdPessoaFisica(Long id);

	Boolean existsByIdPessoaFisica(Long idPessoaFisica);

	void deleteByIdPessoaFisica(Long idPessoaFisica);

}
