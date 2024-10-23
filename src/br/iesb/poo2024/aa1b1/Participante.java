package br.iesb.poo2024.aa1b1;

import java.util.ArrayList;
import java.util.List;

public class Participante extends Usuario {
    private List<Lance> historicoLances;

    public Participante() {
        this.historicoLances = new ArrayList<>();
    }

    @Override
    public boolean login(String email, String senha) {
        if(email == this.email && senha == this.senha){
            System.out.println("Participante logado com sucesso");
            return true;
        }
        System.out.println("Email ou senha incorretos");
        return false;
    }

    @Override
    public void cadastrar(String nome, String email, String senha) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
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