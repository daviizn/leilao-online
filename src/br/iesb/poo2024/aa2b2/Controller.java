package br.iesb.poo2024.aa2b2;

import java.util.List;

public class Controller {
    private Usuario usuario;
    private View view;
    private Ranking ranking;
    private Unidade unidade;

    public Controller(Usuario usuario, View view, Ranking ranking, Unidade unidade) {
        this.usuario = usuario;
        this.view = view;
        this.ranking = ranking;
        this.unidade = unidade;
    }

    public void fazerAtividade(Atividade atividade, String resposta) {
        boolean respostaCorreta = usuario.fazerAtividade(atividade, resposta);
        view.exibirAtividadesFeitas(usuario, atividade, respostaCorreta);
    }

    public void recomendarAtividades() {
        List<Atividade> atividades = usuario.recomendarAtividades(unidade);
        view.exibirRecomendacoes(usuario, atividades);
    }

    public void acessarConquistas() {
        view.exibirProgresso(usuario);
    }

    public void exibirRanking() {
        List<Usuario> usuariosOrdenados = ranking.obterRankingOrdenado();
        view.exibirRanking(usuariosOrdenados);
    }
}
