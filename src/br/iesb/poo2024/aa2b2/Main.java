package br.iesb.poo2024.aa2b2;

public class Main {

	/*
 Instituição: IESB
 Disciplina:  Programação Orientada a Objetos (POO)
 Objetivo: 	  Fazer a implementação de 4 HU's .
 Professor:   Bruno Miranda [bruno.marcos@iesb.edu.br]
 Data:		  2024/25

 # Prática: Atividade Avaliativa 2-B2 – Implementação de um estudo de caso em Java e princípios de arquitetura
 */

	public static void main(String[] args) {
		System.out.println("Davi Serra Bezerra - 2312130031 e Guilherme Tempesta - 2312130221");
		System.out.println("POO2024 - 28/11/2024");

		// Criação das atividades com diferentes níveis de dificuldade
		Atividade atividade1 = new Atividade("Introdução à POO", "Atividade sobre conceitos básicos de POO", "fácil");
		Atividade atividade2 = new Atividade("Classes e Objetos", "Atividade sobre criação de classes e objetos", "médio");
		Atividade atividade3 = new Atividade("Herança e Polimorfismo", "Atividade sobre herança e polimorfismo", "difícil");

		// Criação de uma unidade e adicionando atividades
		Unidade unidade1 = new Unidade(1, "Fundamentos de POO", "Unidade sobre conceitos fundamentais de Programação Orientada a Objetos");
		unidade1.adicionarAtividadeNaUnidade(atividade1);
		unidade1.adicionarAtividadeNaUnidade(atividade2);
		unidade1.adicionarAtividadeNaUnidade(atividade3);

		// Criação de usuários
		Usuario usuario1 = new Usuario("Guilherme Tempesta", "guilherme@exemplo.com");
		Usuario usuario2 = new Usuario("Davi Serra", "davi@exemplo.com");

		// Criação do ranking e adicionando usuários
		Ranking ranking = new Ranking();
		ranking.adicionarUsuarioNoRanking(usuario1);
		ranking.adicionarUsuarioNoRanking(usuario2);

		// Criação da View
		View view = new View();

		// Criação do Controller
		Controller controller = new Controller(usuario1, view, ranking, unidade1);

		// Simulando ações de usuários
		System.out.println("===== Interações do Usuário 1 =====");
		controller.fazerAtividade(atividade1, "correto");  // Usuario 1 acertando a atividade 1
		controller.fazerAtividade(atividade2, "correto");   // Usuario 1 acertando a atividade 2
		controller.fazerAtividade(atividade3, "errado");   // Usuario 1 errando a atividade 3
		controller.recomendarAtividades();                  // Recomenda atividades para o usuário 1
		controller.acessarConquistas();                     // Mostra o progresso e conquistas de usuario 1
		controller.exibirRanking();                         // Exibe o ranking com todos os usuários

		System.out.println("\n===== Interações do Usuário 2 =====");
		controller = new Controller(usuario2, view, ranking, unidade1);  // Alterando o Controller para o usuário 2
		controller.fazerAtividade(atividade1, "correto");  // Usuario 2 fazendo a atividade 1 corretamente
		controller.fazerAtividade(atividade2, "correto");   // Usuario 2 fazendo a atividade 2 corretamente
		controller.fazerAtividade(atividade3, "correto");   // Usuario 2 fazendo a atividade 3 corretamente
		controller.recomendarAtividades();                 // Recomenda atividades para o usuário 2
		controller.acessarConquistas();                    // Mostra o progresso e conquistas de usuario 2
		controller.exibirRanking();                        // Exibe o ranking com todos os usuários
	}
}
