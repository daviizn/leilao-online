package br.iesb.poo2024.aa2b2;

import java.util.List;

public class View {

    public void exibirAtividadesFeitas(Usuario usuario, Atividade atividade, boolean respostaCorreta) {
        System.out.println("\nA atividade: " + atividade.getTituloAtividade() + " foi feita por: " + usuario.getNome());
        if (respostaCorreta) {
            System.out.println("Parabéns, resposta correta!!");
        } else {
            System.out.println("Resposta errada. Mas não desanime, tente novamente");
        }
    }

    public void exibirRecomendacoes(Usuario usuario, List<Atividade> atividades) {
        System.out.println("\nRecomendações para " + usuario.getNome() + ":");
        for (Atividade atividade : atividades) {
            System.out.println("Recomendação: " + atividade.getTituloAtividade() + " - Dificuldade: " + atividade.getDificuldadeAtividade());
        }
    }

    public void exibirRanking(List<Usuario> usuariosOrdenados) {
        System.out.println("\nRanking:");
        for (int i = 0; i < usuariosOrdenados.size(); i++) {
            Usuario usuario = usuariosOrdenados.get(i);
            System.out.println((i + 1) + ". " + usuario.getNome() + " - " + usuario.getPontuacao() + " pontos");
        }
    }

    public void exibirProgresso(Usuario usuario) {
        System.out.println("\nProgresso de " + usuario.getNome() + ":");
        System.out.println("Pontuação Atual: " + usuario.getPontuacao());

        System.out.println("Conquistas:");
        if (usuario.getConquistas().isEmpty()) {
            System.out.println("Nenhuma conquista desbloqueada ainda.");
        } else {
            for (String conquista : usuario.getConquistas()) {
                System.out.println("- " + conquista);
            }
        }

        System.out.println(usuario.calcularProximoNivel());
    }
}
