package br.com.mssantos.cadastropessoa.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mssantos.cadastropessoa.service.ContatoService;
import br.com.mssantos.cadastropessoa.vo.ContatoVO;

@RestController
@RequestMapping("contatopessoafisica")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ContatoController {

	@Autowired
	ContatoService contatoService;
	
	@GetMapping("/{idPessoaFisica}")
	public ResponseEntity<ContatoVO> buscarContatoPorIdPessoaFisica(Long idPessoaFisica) {
		
		return ResponseEntity.status(HttpStatus.OK).body(contatoService.buscarContatoPorIdPessoaFisica(idPessoaFisica));
	}
	
	@PostMapping
	public ResponseEntity<ContatoVO> salvarContato(@Valid @RequestBody ContatoVO contatoVO){
		
		return ResponseEntity.status(HttpStatus.CREATED).body(contatoService.salvarContato(contatoVO));
	}
	
	@PutMapping
	public ResponseEntity<ContatoVO> atualizarContatoPorIdPessoaFisica(@Valid @RequestBody ContatoVO contatoVO){
	
		return ResponseEntity.status(HttpStatus.OK).body(contatoService.atualizarContatoPorIdPessoaFisica(contatoVO));
	}
	
	@DeleteMapping("/{idPessoaFisica}")
	public ResponseEntity<String> deletarPessoaFisicaPorId(Long idPessoaFisica) {
		
		return ResponseEntity.status(HttpStatus.OK).body(contatoService.deletarPessoaFisicaPorId(idPessoaFisica));

	}
}
