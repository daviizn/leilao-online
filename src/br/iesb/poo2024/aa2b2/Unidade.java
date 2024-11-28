package br.iesb.poo2024.aa2b2;

import java.util.ArrayList;
import java.util.List;

public class Unidade {
	private int idUnidade;
	private String nomeUnidade;
	private String descricaoUnidade;
	private List<Atividade> atividades;

	public Unidade(int idUnidade, String nomeUnidade, String descricaoUnidade) {
		this.idUnidade = idUnidade;
		this.nomeUnidade = nomeUnidade;
		this.descricaoUnidade = descricaoUnidade;
		this.atividades = new ArrayList<>();
	}

	public void adicionarAtividadeNaUnidade(Atividade atividade) {
		atividades.add(atividade);
		atividade.setUnidade(this);
	}

	public List<Atividade> getAtividades() {
		return atividades;
	}

	public int getIdUnidade() {
		return idUnidade;
	}

	public void setIdUnidade(int idUnidade) {
		this.idUnidade = idUnidade;
	}

	public String getNomeUnidade() {
		return nomeUnidade;
	}

	public void setNomeUnidade(String nomeUnidade) {
		this.nomeUnidade = nomeUnidade;
	}

	public String getDescricaoUnidade() {
		return descricaoUnidade;
	}

	public void setDescricaoUnidade(String descricaoUnidade) {
		this.descricaoUnidade = descricaoUnidade;
	}
}

