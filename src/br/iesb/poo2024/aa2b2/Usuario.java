package br.iesb.poo2024.aa2b2;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String nome;
	private String email;
	private int pontuacao;
	private List<String> conquistas;

	public Usuario(String nome, String email) {
		this.nome = nome;
		this.email = email;
		this.pontuacao = 0; // Inicializa com 0 pontos
		this.conquistas = new ArrayList<>();
	}

	// HU de poder realizar a atividade - feito por Guilherme Tempesta
	public boolean fazerAtividade(Atividade atividade, String resposta) {
		boolean respostaCorreta = atividade.isRespostaCorreta(resposta);
		if (respostaCorreta) {
			this.pontuacao += 10; // Ganha 10 pontos por atividade correta
			verificarConquistas();
		}
		return respostaCorreta;
	}

	// HU para recomendar atividades - feito por Davi Serra
	public List<Atividade> recomendarAtividades(Unidade unidade) {
		List<Atividade> recomendadas = new ArrayList<>();
		if (pontuacao < 30) {
			for (Atividade atividade : unidade.getAtividades()) {
				if ("fácil".equalsIgnoreCase(atividade.getDificuldadeAtividade())) {
					recomendadas.add(atividade);
				}
			}
		} else if (pontuacao < 60) {
			for (Atividade atividade : unidade.getAtividades()) {
				if ("médio".equalsIgnoreCase(atividade.getDificuldadeAtividade())) {
					recomendadas.add(atividade);
				}
			}
		} else {
			for (Atividade atividade : unidade.getAtividades()) {
				if ("difícil".equalsIgnoreCase(atividade.getDificuldadeAtividade())) {
					recomendadas.add(atividade);
				}
			}
		}
		return recomendadas;
	}

	// HU adicionar Conquistas e visualizar progresso - feito por Davi Serra
	public String calcularProximoNivel() {
		int proximoNivel = 0;
		int pontosParaProximoNivel = 0;

		if (this.pontuacao < 10) {
			proximoNivel = 10;
			pontosParaProximoNivel = 10 - this.pontuacao;
		} else if (this.pontuacao < 50) {
			proximoNivel = 50;
			pontosParaProximoNivel = 50 - this.pontuacao;
		} else if (this.pontuacao < 100) {
			proximoNivel = 100;
			pontosParaProximoNivel = 100 - this.pontuacao;
		} else if (this.pontuacao < 200) {
			proximoNivel = 200;
			pontosParaProximoNivel = 200 - this.pontuacao;
		} else if (this.pontuacao < 500) {
			proximoNivel = 500;
			pontosParaProximoNivel = 500 - this.pontuacao;
		} else {
			proximoNivel = 500;
			pontosParaProximoNivel = 0;
		}

		return "Faltam " + pontosParaProximoNivel + " pontos para o próximo nível (" + proximoNivel + ").";
	}


	// HU adicionar Conquistas e visualizar progresso - feito por Davi Serra
	private void verificarConquistas() {
		if (pontuacao >= 10 && !conquistas.contains("Novato")) {
			conquistas.add("Novato");
		}
		if (pontuacao >= 50 && !conquistas.contains("Intermediário")) {
			conquistas.add("Intermediário");
		}
		if (pontuacao >= 100 && !conquistas.contains("Avançado")) {
			conquistas.add("Avançado");
		}
		if (pontuacao >= 200 && !conquistas.contains("Especialista")) {
			conquistas.add("Especialista");
		}
		if (pontuacao >= 500 && !conquistas.contains("Mestre")) {
			conquistas.add("Mestre");
		}
	}

	// Getters e Setters
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public List<String> getConquistas() {
		return conquistas;
	}

	public void setConquistas(List<String> conquistas) {
		this.conquistas = conquistas;
	}
}
