package br.com.mssantos.cadastropessoa.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.mssantos.cadastropessoa.service.PessoaFisicaService;
import br.com.mssantos.cadastropessoa.vo.PessoaFisicaFiltrosVO;
import br.com.mssantos.cadastropessoa.vo.PessoaFisicaResumidaVO;
import br.com.mssantos.cadastropessoa.vo.PessoaFisicaVO;

@RestController
@RequestMapping("pessoafisica")
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class PessoaFisicaController {

	@Autowired
	PessoaFisicaService pessoaFisicaService;

	@GetMapping("/filtros")
	public ResponseEntity<Page<PessoaFisicaResumidaVO>> buscarPessoaFisicaPorFiltros(
			@PageableDefault(size = 20) Pageable pageable, PessoaFisicaFiltrosVO pessoaFisicaFiltros) {

		return ResponseEntity.status(HttpStatus.OK)
				.body(pessoaFisicaService.buscarPessoaFisicaPorFiltros(pageable, pessoaFisicaFiltros));
	}

	@GetMapping("/{id}")
	public ResponseEntity<PessoaFisicaVO> buscarPessoaFisicaPorId(Long id) {

		return ResponseEntity.status(HttpStatus.OK).body(pessoaFisicaService.buscarPessoaFisicaPorId(id));
	}

	@PostMapping
	public ResponseEntity<PessoaFisicaVO> salvarPessoaFisica(@RequestBody PessoaFisicaVO pessoaFisicaVO) {

		return ResponseEntity.status(HttpStatus.CREATED).body(pessoaFisicaService.salvarPessoaFisica(pessoaFisicaVO));
	}

	@PutMapping
	public ResponseEntity<PessoaFisicaVO> alterarPessoaFisicaPorId(@RequestBody PessoaFisicaVO pessoaFisicaVO) {

		return ResponseEntity.status(HttpStatus.OK).body(pessoaFisicaService.alterarPessoaFisicaPorId(pessoaFisicaVO));
	}

}
