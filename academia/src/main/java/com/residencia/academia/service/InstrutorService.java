package com.residencia.academia.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.academia.DTO.InstrutorDTO;
import com.residencia.academia.DTO.TurmaDTO;
import com.residencia.academia.entity.Instrutor;
import com.residencia.academia.entity.Turma;
import com.residencia.academia.repository.InstrutorRepository;

@Service
public class InstrutorService {
	@Autowired
	InstrutorRepository instrutorRepository;

	public List<Instrutor> findAllInstrutor() {
		return instrutorRepository.findAll();
	}

	public InstrutorDTO findInstrutorDTOById(Integer id) {
		Instrutor instrutor = instrutorRepository.findById(id).isPresent() ? instrutorRepository.findById(id).get()
				: null;
		InstrutorDTO instrutorDTO = new InstrutorDTO();
		if (null != instrutor) {
			instrutorDTO = converterEntidadeParaDTO(instrutor);
		}
		return instrutorDTO;
	}

	private InstrutorDTO converterEntidadeParaDTO(Instrutor instrutor) {
		InstrutorDTO instrutorDTO = new InstrutorDTO();
		instrutorDTO.setDataNascimento(instrutor.getDataNascimento());
		instrutorDTO.setIdInstrutor(instrutor.getIdInstrutor());
		instrutorDTO.setNomeInstrutor(instrutor.getNomeInstrutor());
		instrutorDTO.setRg(instrutor.getRg());
		instrutorDTO.setTitulacao(instrutor.getTitulacao());

		List<TurmaDTO> ListaTurmaDTO = new ArrayList<>();
		if (instrutor.getTurmaList() != null) {
			for (Turma turma : instrutor.getTurmaList()) {
				TurmaDTO turmaDTO = new TurmaDTO();
				turmaDTO.setDataFim(turma.getDataFim());
				turmaDTO.setDataInicio(turma.getDataInicio());
				turmaDTO.setDuracaoTurma(turma.getDuracaoTurma());
				turmaDTO.setHorarioTurma(turma.getHorarioTurma());
				turmaDTO.setIdTurma(turma.getIdTurma());
				ListaTurmaDTO.add(turmaDTO);
			}
		}

		instrutorDTO.setTurmaDTOList(ListaTurmaDTO);
		return instrutorDTO;
	}

	public Instrutor findInstrutorById(Integer id) {
		return instrutorRepository.findById(id).isPresent() ? instrutorRepository.findById(id).get() : null;
	}

	public Instrutor saveInstrutor(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}

	public InstrutorDTO saveInstrutorDTO(InstrutorDTO instrutorDTO) {
		Instrutor instrutor = new Instrutor();
		instrutor = converterDTOParaEntidade(instrutorDTO);
		saveInstrutor(instrutor);
		instrutorDTO = converterEntidadeParaDTO(instrutor);
		return instrutorDTO;
	}

	private Instrutor converterDTOParaEntidade(InstrutorDTO instrutorDTO) {
		Instrutor instrutor = new Instrutor();
		instrutor.setDataNascimento(instrutorDTO.getDataNascimento());
		instrutor.setIdInstrutor(instrutorDTO.getIdInstrutor());
		instrutor.setNomeInstrutor(instrutorDTO.getNomeInstrutor());
		instrutor.setRg(instrutorDTO.getRg());
		instrutor.setTitulacao(instrutorDTO.getTitulacao());
		return instrutor;
	}

	public Instrutor updateInstrutor(Instrutor instrutor) {
		return instrutorRepository.save(instrutor);
	}

	public void deleteInstrutor(Integer id) {
		Instrutor instrutor = instrutorRepository.findById(id).get();
		instrutorRepository.delete(instrutor);
	}

	public void deleteInstrutor(Instrutor instrutor) {
		instrutorRepository.delete(instrutor);
	}
}
