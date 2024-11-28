package br.iesb.poo2024.aa2b2;

public class Atividade {
	private String tituloAtividade;
	private String descricaoAtividade;
	private String dificuldadeAtividade;
	private Unidade unidade;

	public Atividade(String tituloAtividade, String descricaoAtividade, String dificuldadeAtividade) {
		this.tituloAtividade = tituloAtividade;
		this.descricaoAtividade = descricaoAtividade;
		this.dificuldadeAtividade = dificuldadeAtividade;
	}

	public String getTituloAtividade() {
		return tituloAtividade;
	}

	public void setTituloAtividade(String tituloAtividade) {
		this.tituloAtividade = tituloAtividade;
	}

	public String getDescricaoAtividade() {
		return descricaoAtividade;
	}

	public void setDescricaoAtividade(String descricaoAtividade) {
		this.descricaoAtividade = descricaoAtividade;
	}

	public String getDificuldadeAtividade() {
		return dificuldadeAtividade;
	}

	public void setDificuldadeAtividade(String dificuldadeAtividade) {
		this.dificuldadeAtividade = dificuldadeAtividade;
	}

	public Unidade getUnidade() {
		return unidade;
	}

	public void setUnidade(Unidade unidade) {
		this.unidade = unidade;
	}

	public boolean isRespostaCorreta(String resposta) {
		return "correto".equalsIgnoreCase(resposta);
	}
}
