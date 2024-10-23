package br.iesb.poo2024.aa2b1;

public class Leiloeiro extends Usuario {

    @Override
    public void login(String email, String senha) {
        super.login(email, senha);
    }

    @Override
    public void cadastrar(String nome, String email, String senha) throws Exception {
        super.cadastrar(nome, email, senha);
    }

    @Override
    public void logout() {
        super.logout();
        System.out.println("Leiloeiro deslogado com sucesso.");
    }

    public void gerenciarLeilao(Leilao leilao) {

    }

    public void iniciarLeilao(Leilao leilao) {
        leilao.iniciar(this);
    }

    public void encerrarLeilao(Leilao leilao) {
        leilao.encerrar();
        System.out.println("Leilão encerrado!");
    }
}
