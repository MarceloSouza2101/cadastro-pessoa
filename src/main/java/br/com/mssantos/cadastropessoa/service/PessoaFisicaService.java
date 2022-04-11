package br.com.mssantos.cadastropessoa.service;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import br.com.mssantos.cadastropessoa.entity.PessoaFisicaEntity;
import br.com.mssantos.cadastropessoa.exception.DadosJaCadastradosException;
import br.com.mssantos.cadastropessoa.exception.NaoEncontradoException;
import br.com.mssantos.cadastropessoa.exception.ParametroInvalidoException;
import br.com.mssantos.cadastropessoa.repository.PessoaFisicaRepository;
import br.com.mssantos.cadastropessoa.specification.PessoaFisicaDadosBasicosSpecification;
import br.com.mssantos.cadastropessoa.utils.VerificaCPFUtils;
import br.com.mssantos.cadastropessoa.vo.PessoaFisicaFiltrosVO;
import br.com.mssantos.cadastropessoa.vo.PessoaFisicaResumidaVO;
import br.com.mssantos.cadastropessoa.vo.PessoaFisicaVO;

@Service
public class PessoaFisicaService {

	@Autowired
	PessoaFisicaRepository pessoaFisicaRepository;
	
	private static Logger logger = LoggerFactory.getLogger(PessoaFisicaService.class);
	
	public Page<PessoaFisicaResumidaVO> buscarPessoaFisicaPorFiltros(Pageable pageable, PessoaFisicaFiltrosVO pessoaFisicaFiltros) {

		logger.info("PESQUISA COM FILTRO DE PESSOA NO BANCO");
		
		if (pessoaFisicaFiltros.isFiltrosInexistentes()) {
		    logger.error("PESQUISA INVÁLIDA: FILTROS INEXISTENTES");
		    throw new ParametroInvalidoException("Filtros inexistentes");
		}

		Page<PessoaFisicaEntity> pessoaFiltradas = pessoaFisicaRepository.findAll(new PessoaFisicaDadosBasicosSpecification(pessoaFisicaFiltros), pageable);
		
		return pessoaFiltradas.map(this::converterPessoaFisicaResumida);
	}
	
	public PessoaFisicaVO buscarPessoaFisicaPorId(Long id) {

		logger.info("PESQUISA PELO ID DE PESSOA NO BANCO");
		
		PessoaFisicaEntity pessoaFisica = pessoaFisicaRepository.findById(id)
				.orElseThrow(() -> new NaoEncontradoException("Nenhuma pessoa encontrada com o id: " + id));
		
		return converterParaVO(pessoaFisica);
	}
	
	public PessoaFisicaVO salvarPessoaFisica(PessoaFisicaVO pessoaFisicaVO) {

		logger.info("SALVANDO PESSOA FISICA");
		
		PessoaFisicaEntity pessoaFisicaEntity = new PessoaFisicaEntity();
		
		VerificaCPFUtils.verificaCPF(pessoaFisicaVO.getCpf(), logger);
		
		logger.info("VERIFIFICANDO A EXISTENCIA DE PESSOA FISICA JÁ CADASTRADA NO BANCO");
		if (pessoaFisicaRepository.findByCpf(pessoaFisicaVO.getCpf()).isPresent()) {
			logger.error("DADOS JÁ EXISTENTES NO BANCO");
			throw new DadosJaCadastradosException(
					"Já existe uma Pessoa Física cadastrada com o CPF: " + pessoaFisicaVO.getCpf());
		}
		
		PessoaFisicaEntity pessoaSalva = pessoaFisicaRepository
				.save(converterParaEntity(pessoaFisicaEntity, pessoaFisicaVO));
		
		return converterParaVO(pessoaSalva);
	}
	
	public PessoaFisicaVO alterarPessoaFisicaPorId(PessoaFisicaVO pessoaFisicaVO) {

		VerificaCPFUtils.verificaCPF(pessoaFisicaVO.getCpf(), logger);
		PessoaFisicaEntity pessoaFisicaEntity = pessoaFisicaRepository.findById(pessoaFisicaVO.getIdPessoaFisica())
				.orElseThrow(() -> new ParametroInvalidoException(
						"Não existe Pessoa Física de ID: " + pessoaFisicaVO.getIdPessoaFisica()));

		Optional<PessoaFisicaEntity> pessoaFisicaPorCPF = pessoaFisicaRepository.findByCpf(pessoaFisicaVO.getCpf());


		if (pessoaFisicaPorCPF.isPresent() && !pessoaFisicaPorCPF.get().getId().equals(pessoaFisicaVO.getIdPessoaFisica())) {
			logger.error("CPF INFORMADO NA ALTERACAO JA EXISTE NO BANCO");
			throw new DadosJaCadastradosException(
					"CPF informado já existe no banco de dados: " + pessoaFisicaVO.getCpf());
		}

		return alterarPessoaFisica(pessoaFisicaEntity, pessoaFisicaVO);
	}

	private PessoaFisicaVO alterarPessoaFisica(PessoaFisicaEntity pessoaFisicaEntity, PessoaFisicaVO pessoaFisicaVO) {
		
		pessoaFisicaEntity.setCpf(pessoaFisicaVO.getCpf());
		pessoaFisicaEntity.setId(pessoaFisicaVO.getIdPessoaFisica());
		pessoaFisicaEntity.setIdGenero(pessoaFisicaVO.getIdGenero());
		pessoaFisicaEntity.setNome(pessoaFisicaVO.getNome());
		pessoaFisicaEntity.setNomeMae(pessoaFisicaVO.getNomeMae());
		pessoaFisicaEntity.setIdProfissao(pessoaFisicaVO.getIdProfissao());
		
		PessoaFisicaEntity save = pessoaFisicaRepository.save(pessoaFisicaEntity);
		
		return this.converterParaVO(save);
	}

	private PessoaFisicaEntity converterParaEntity(PessoaFisicaEntity pessoaFisicaEntity, PessoaFisicaVO pessoaFisicaVO) {

		pessoaFisicaEntity.setCpf(pessoaFisicaVO.getCpf());
		pessoaFisicaEntity.setNome(pessoaFisicaVO.getNome());
		pessoaFisicaEntity.setNomeMae(pessoaFisicaVO.getNomeMae());
		pessoaFisicaEntity.setIdGenero(pessoaFisicaVO.getIdGenero());
		pessoaFisicaEntity.setIdProfissao(pessoaFisicaVO.getIdProfissao());
		
		return pessoaFisicaEntity;
	}

	private PessoaFisicaVO converterParaVO(PessoaFisicaEntity pessoaFisica) {

		PessoaFisicaVO vo = new PessoaFisicaVO();
		
		vo.setCpf(pessoaFisica.getCpf());
		vo.setIdGenero(pessoaFisica.getIdGenero());
		vo.setIdPessoaFisica(pessoaFisica.getId());
		vo.setIdProfissao(pessoaFisica.getIdProfissao());
		vo.setNome(pessoaFisica.getNome());
		vo.setNomeMae(pessoaFisica.getNomeMae());
		
		return vo;
	}

	private PessoaFisicaResumidaVO converterPessoaFisicaResumida(PessoaFisicaEntity pessoaFisica) {
		PessoaFisicaResumidaVO vo = new PessoaFisicaResumidaVO();

		vo.setCpf(pessoaFisica.getCpf());
		vo.setNome(pessoaFisica.getNome());
		vo.setIdProfissao(pessoaFisica.getIdProfissao());
//		ContatoVO contatoPorIdDePessoaFisica = contatoService.buscarContatoPorIdDePessoaFisica(pessoaFisica.getIdPessoaFisica());
//		vo.setContato(contatoPorIdDePessoaFisica.getTelefoneCelularVo());

		return vo;
	}

}
