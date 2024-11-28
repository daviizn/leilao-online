package br.iesb.poo2024.aa2b2;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ranking {
	private List<Usuario> usuarios;

	public Ranking() {
		this.usuarios = new ArrayList<>();
	}

	public void adicionarUsuarioNoRanking(Usuario usuario) {
		usuarios.add(usuario);
	}

	// HU para o usuário pode visualizar o ranking - feito por Guilherme Tempesta
	public List<Usuario> obterRankingOrdenado() {
		Collections.sort(usuarios, (u1, u2) -> {
			int scoreComparison = Integer.compare(u2.getPontuacao(), u1.getPontuacao());
			if (scoreComparison != 0) {
				return scoreComparison;
			}
			return u1.getNome().compareTo(u2.getNome());  // Caso de empate, ordena por nome
		});
		return usuarios;
	}
}


