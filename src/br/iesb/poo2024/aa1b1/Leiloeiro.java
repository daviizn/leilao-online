package br.iesb.poo2024.aa1b1;

public class Leiloeiro extends Usuario {

    @Override
    public boolean login(String email, String senha) {
        if(email == this.email && senha == this.senha){
            System.out.println("Leiloeiro logado com sucesso");
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

    public void gerenciarLeilao(Leilao leilao) {

    }

    public void iniciarLeilao(Leilao leilao) {
        leilao.iniciar();
    }

    public void encerrarLeilao(Leilao leilao) {
        leilao.encerrar();
        System.out.println("Leilão encerrado!");
    }
}