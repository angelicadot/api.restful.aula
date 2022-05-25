package com.residencia.academia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.residencia.academia.DTO.TurmaDTO;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.exception.NoSuchElementFoundException;
import com.residencia.academia.service.TurmaService;

@RestController
@RequestMapping("/turma")
public class TurmaController {
	@Autowired
	TurmaService turmaService;

	@GetMapping
	public ResponseEntity<List<Turma>> findAllTurma() {
		List<Turma> turmaList = turmaService.findAllTurma();
		return new ResponseEntity<>(turmaList, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<Turma> findTurmaById(@PathVariable Integer id) {
		Turma turma = turmaService.findByTurmaId(id);
		if(turma == null) {
			throw new NoSuchElementFoundException("Não foi possível achar a atividade, "
					+ "pois não foi "
					+ "encontrada uma turma com o id " + id);
		}else {	
			return new ResponseEntity<>(turma, HttpStatus.OK);// para corrigir a mensagem pelo codigo
		}
	}
	
	@GetMapping("/dto/{id}")
	public ResponseEntity<TurmaDTO> findTurmaDTOById(@PathVariable Integer id) {
		TurmaDTO turmaDTO = turmaService.findByTurmaDTOId(id);
		if(turmaDTO == null) {
			throw new NoSuchElementFoundException("Não foi possível achar a atividade, "
					+ "pois não foi "
					+ "encontrada uma turma com o id " + id);
		}else {	
			return new ResponseEntity<>(turmaDTO, HttpStatus.OK);// para corrigir a mensagem pelo codigo
		}
	}


//	@PostMapping
//	public Turma save(@RequestBody Turma turma) {
//		return turmaService.saveTurma(turma);
//	}
	
	@PostMapping
	public ResponseEntity<Turma> saveTurma(@RequestBody Turma turma) {
		return new ResponseEntity<>(turmaService.saveTurma(turma),HttpStatus.CREATED);
	}
	
	@PostMapping("/dto")
	public ResponseEntity<TurmaDTO> saveTurmaDTO(@RequestBody TurmaDTO turmaDTO) {
		return new ResponseEntity<>(turmaService.saveTurmaDTO(turmaDTO),HttpStatus.CREATED);
	}

	@PutMapping
	public ResponseEntity<Turma> updateTurma(@RequestBody Turma turma) {
		return new ResponseEntity<>(turmaService.updateTurma(turma),HttpStatus.OK);
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTurma(@PathVariable Integer id) {
		Turma turma = turmaService.findByTurmaId(id);
		if(null == turma)
			throw new NoSuchElementFoundException("Não foi possível excluir a Turma, "
					+ "pois não foi "
					+ "encontrada uma turma com o id " + id);

		turmaService.deleteById(id);
		return new ResponseEntity<>("", HttpStatus.OK);
	}
	
	/*
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTurmaComConferencia(@PathVariable I
/*
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteTurmaComConferencia(@PathVariable Integer id) {
		Boolean verificacao = turmaService.deleteTurmaComConferencia(id);
		if(verificacao)
			return new ResponseEntity<>("", HttpStatus.OK);
		else
			throw new NoSuchElementFoundException("Não foi possível excluir a Turma, "
					+ "pois não foi "
					+ "encontrada uma turma com o id " + id);
		
	}
	*/
}
