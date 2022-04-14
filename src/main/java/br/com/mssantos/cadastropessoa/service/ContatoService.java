package br.com.mssantos.cadastropessoa.service;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mssantos.cadastropessoa.entity.ContatoEntity;
import br.com.mssantos.cadastropessoa.exception.DadosJaCadastradosException;
import br.com.mssantos.cadastropessoa.exception.NaoEncontradoException;
import br.com.mssantos.cadastropessoa.repository.ContatoRepository;
import br.com.mssantos.cadastropessoa.vo.ContatoVO;

@Service
public class ContatoService {

	@Autowired
	ContatoRepository contatoRepository;

	@Autowired
	PessoaFisicaService fisicaService;

	private static Logger logger = LoggerFactory.getLogger(ContatoService.class);

	public ContatoVO buscarContatoPorIdPessoaFisica(Long idPessoaFisica) {

		logger.info("Pesquisando contato por id pessoa fisica");

		validarSePessoaExiste(idPessoaFisica);
		ContatoEntity contato = contatoRepository.findByIdPessoaFisica(idPessoaFisica)
				.orElseThrow(() -> new NaoEncontradoException("Nenhum contato encontrado com id da pessoa " + idPessoaFisica));

		return converterParaVO(contato, new ContatoVO());
	}

	private void validarSePessoaExiste(Long idPessoaFisica) {
		fisicaService.buscarPessoaFisicaPorId(idPessoaFisica);
	}
	
	public ContatoVO salvarContato(ContatoVO contatoVO) {

		validarSePessoaExiste(contatoVO.getIdPessoaFisica());
		
		if(Boolean.TRUE.equals(contatoRepository.existsByIdPessoaFisica(contatoVO.getIdPessoaFisica()))){
			throw new DadosJaCadastradosException("Já existe contato para pessoa do id " + contatoVO.getIdPessoaFisica());
		}
		
		ContatoEntity entity = contatoRepository.save(converterVoParaEntity(contatoVO));
		
		
		return converterParaVO(entity, new ContatoVO());
	}
	
	public ContatoVO atualizarContatoPorIdPessoaFisica(ContatoVO contatoVO) {
		
		validarSePessoaExiste(contatoVO.getIdPessoaFisica());
		
		ContatoEntity contatoEntity = contatoRepository.findByIdPessoaFisica(contatoVO.getIdPessoaFisica())
				.orElseThrow(() -> new NaoEncontradoException("Nenhum contato encontrado com id da pessoa " + contatoVO.getIdPessoaFisica()));

		ContatoEntity contato = contatoRepository.save(converterParaEntity(contatoEntity, contatoVO));
		
		return converterParaVO(contato, new ContatoVO());
	}
	
	@Transactional
	public String deletarPessoaFisicaPorId(Long idPessoaFisica) {

		validarSePessoaExiste(idPessoaFisica);
		
		ContatoEntity contatoEntity = contatoRepository.findByIdPessoaFisica(idPessoaFisica)
				.orElseThrow(() -> new NaoEncontradoException("Nenhum contato encontrado com id da pessoa " + idPessoaFisica));
		
		contatoRepository.deleteByIdPessoaFisica(contatoEntity.getIdPessoaFisica());
		
		return "Contato deletado";
	}
	
	
	private ContatoEntity converterParaEntity(ContatoEntity entity, ContatoVO vo) {

		entity.setIdPessoaFisica(vo.getIdPessoaFisica());
		entity.setTelefoneCelular(vo.getTelefoneCelular());
		entity.setObservacaoContato(vo.getObservacaoContato());
		entity.setEmail(vo.getEmail());
		entity.setFlagEmail(vo.getFlagReceberEmail());
		entity.setFlagSms(vo.getFlagReceberSms());
		
		return entity;
	}

	private ContatoEntity converterVoParaEntity(ContatoVO vo) {

		ContatoEntity entity = new ContatoEntity();
		
		entity.setIdPessoaFisica(vo.getIdPessoaFisica());
		entity.setTelefoneCelular(vo.getTelefoneCelular());
		entity.setObservacaoContato(vo.getObservacaoContato());
		entity.setEmail(vo.getEmail());
		entity.setFlagEmail(vo.getFlagReceberEmail());
		entity.setFlagSms(vo.getFlagReceberSms());
		return entity;
	}

	private ContatoVO converterParaVO(ContatoEntity entity, ContatoVO contato) {
		 
		contato.setIdContato(entity.getId());
		contato.setIdPessoaFisica(entity.getIdPessoaFisica());
		contato.setEmail(entity.getEmail());
		contato.setTelefoneCelular(entity.getTelefoneCelular());
		contato.setFlagReceberEmail(entity.getFlagEmail());
		contato.setFlagReceberSms(entity.getFlagSms());
		contato.setObservacaoContato(entity.getObservacaoContato());

		return contato;
	}

}
