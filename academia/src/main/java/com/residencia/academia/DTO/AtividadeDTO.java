package com.residencia.academia.DTO;

import java.util.List;

public class AtividadeDTO {
	private Integer atividadeId;
	private String nomeAtividade;
	private List<TurmaDTO> turmaDTOList;
	
	public Integer getAtividadeId() {
		return atividadeId;
	}
	public void setAtividadeId(Integer atividadeId) {
		this.atividadeId = atividadeId;
	}
	public String getNomeAtividade() {
		return nomeAtividade;
	}
	public void setNomeAtividade(String nomeAtividade) {
		this.nomeAtividade = nomeAtividade;
	}
	public List<TurmaDTO> getTurmaDTOList() {
		return turmaDTOList;
	}
	public void setTurmaDTOList(List<TurmaDTO> turmaDTOList) {
		this.turmaDTOList = turmaDTOList;
	}
	
	
	
}
