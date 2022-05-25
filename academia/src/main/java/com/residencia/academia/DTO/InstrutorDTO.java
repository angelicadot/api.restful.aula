package com.residencia.academia.DTO;

import java.util.Date;
import java.util.List;

public class InstrutorDTO {

	private Integer idInstrutor;
	private Integer rg;
	private String nomeInstrutor;
	private Date dataNascimento;
	private Integer titulacao;
	private List<TurmaDTO> turmaDTOList;

	public List<TurmaDTO> getTurmaDTOList() {
		return turmaDTOList;
	}

	public void setTurmaDTOList(List<TurmaDTO> turmaDTOList) {
		this.turmaDTOList = turmaDTOList;
	}

	public Integer getIdInstrutor() {
		return idInstrutor;
	}

	public void setIdInstrutor(Integer idInstrutor) {
		this.idInstrutor = idInstrutor;
	}

	public Integer getRg() {
		return rg;
	}

	public void setRg(Integer rg) {
		this.rg = rg;
	}

	public String getNomeInstrutor() {
		return nomeInstrutor;
	}

	public void setNomeInstrutor(String nomeInstrutor) {
		this.nomeInstrutor = nomeInstrutor;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Integer getTitulacao() {
		return titulacao;
	}

	public void setTitulacao(Integer titulacao) {
		this.titulacao = titulacao;
	}

	@Override
	public String toString() {
		return "InstrutorDTO [idInstrutor=" + idInstrutor + ", rg=" + rg + ", nomeInstrutor=" + nomeInstrutor
				+ ", dataNascimento=" + dataNascimento + ", titulacao=" + titulacao + "]";
	}

}
