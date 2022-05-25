package com.residencia.academia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.DTO.TurmaDTO;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repository.TurmaRepository;

@Service
public class TurmaService {
	@Autowired
	TurmaRepository turmaRepository;

	public List<Turma> findAllTurma() {
		return turmaRepository.findAll();
	}

	public Turma findByTurmaId(Integer id) {
		return turmaRepository.findById(id).isPresent() ? turmaRepository.findById(id).get() : null;
	}

	public TurmaDTO findByTurmaDTOId(Integer id) {
		Turma turma = turmaRepository.findById(id).isPresent() ? turmaRepository.findById(id).get() : null;
		TurmaDTO turmaDTO = new TurmaDTO();
		if (null != turma) {
			turmaDTO = converterEntidadeParaDTO(turma);
		}
		return turmaDTO;
	}

	public Turma saveTurma(Turma turma) {
		return turmaRepository.save(turma);
	}

	public TurmaDTO saveTurmaDTO(TurmaDTO turmaDTO) {
		Turma turma = new Turma();
		turma = converterDTOParaEntidade(turmaDTO);
		saveTurma(turma);
		turmaDTO = converterEntidadeParaDTO(turma);
		return turmaDTO;
	}

	public Turma updateTurma(Turma turma) {
		return turmaRepository.save(turma);
	}

	public void deleteById(Integer id) {
		turmaRepository.deleteById(id);
	}

	private TurmaDTO converterEntidadeParaDTO(Turma turma) {
		TurmaDTO turmaDTO = new TurmaDTO();
		turmaDTO.setDataFim(turma.getDataFim());
		turmaDTO.setDataInicio(turma.getDataInicio());
		turmaDTO.setDuracaoTurma(turma.getDuracaoTurma());
		turmaDTO.setHorarioTurma(turma.getHorarioTurma());
		turmaDTO.setIdTurma(turma.getIdTurma());
		turmaDTO.setInstrutor(turma.getInstrutor());
		turmaDTO.setAtividade(turma.getAtividade());
		return turmaDTO;
	}

	private Turma converterDTOParaEntidade(TurmaDTO turmaDTO) {
		Turma turma = new Turma();
		turma.setDataFim(turmaDTO.getDataFim());
		turma.setDataInicio(turmaDTO.getDataInicio());
		turma.setDuracaoTurma(turmaDTO.getDuracaoTurma());
		turma.setHorarioTurma(turmaDTO.getHorarioTurma());
		turma.setIdTurma(turmaDTO.getIdTurma());
		turma.setInstrutor(turmaDTO.getInstrutor());
		turma.setAtividade(turmaDTO.getAtividade());
		return turma;
	}

	/*
	 * public Boolean deleteTurmaComConferencia(Integer id) {
	 * if(turmaRepository.findById(id).isPresent()) {
	 * turmaRepository.deleteById(id); return true; }else { return false; } }
	 */

}
