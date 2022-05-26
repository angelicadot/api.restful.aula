package com.residencia.academia.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.DTO.InstrutorDTO;
import com.residencia.academia.DTO.TurmaDTO;
import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repository.TurmaRepository;

@Service
public class TurmaService {
	@Autowired
	TurmaRepository turmaRepository;
	
	@Autowired
	private AtividadeService atividadeService;
	
	@Autowired
	InstrutorService instrutorService;

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
		InstrutorDTO instrutor = instrutorService.findInstrutorDTOById(turma.getInstrutor().getIdInstrutor());
		turmaDTO.setInstrutorDTO(instrutor);
			return turmaDTO;
	}

	private Turma converterDTOParaEntidade(TurmaDTO turmaDTO) {
		Turma turma = new Turma();
		turma.setDataFim(turmaDTO.getDataFim());
		turma.setDataInicio(turmaDTO.getDataInicio());
		turma.setDuracaoTurma(turmaDTO.getDuracaoTurma());
		turma.setHorarioTurma(turmaDTO.getHorarioTurma());
		turma.setIdTurma(turmaDTO.getIdTurma());
		Instrutor instrutor = instrutorService.findInstrutorById(turmaDTO.getInstrutorDTO().getIdInstrutor());
		turma.setInstrutor(instrutor);
			return turma;
	}

}
