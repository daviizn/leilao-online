package br.iesb.poo2024.aa2b1;

import java.util.ArrayList;
import java.util.List;

public class Participante extends Usuario {
    private List<Lance> historicoLances;

    public Participante() {
        this.historicoLances = new ArrayList<>();
    }

    @Override
    public void login(String email, String senha) {
        super.login(email, senha);
    }

    @Override
    public void cadastrar(String nome, String email, String senha) throws Exception {
        super.cadastrar(nome, email, senha);
    }

    public void darLance(Lance lance) {
        historicoLances.add(lance);
    }

    public List<Lance> getHistorico() {
        return historicoLances;
    }

    public String getNome() {
        return this.nome;
    }
}
