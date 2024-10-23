package br.iesb.poo2024.aa2b1;

import br.iesb.poo2024.aa2b1.excecoes.EmailDuplicadoException;

import java.util.ArrayList;
import java.util.List;

public abstract class Usuario {
    protected String nome;
    protected String email;
    protected String senha;
    protected boolean logado;

    private static List<Usuario> usuariosCadastrados = new ArrayList<>();

    public void login(String email, String senha) {
        if (email.equals(this.email) && senha.equals(this.senha)) {
            this.logado = true;
            System.out.println("Usuário logado com sucesso.");
        } else {
            this.logado = false;
            System.out.println("Email ou senha incorretos.");
        }
    }

    public void cadastrar(String nome, String email, String senha) throws Exception {
        try {
            if (nome == null || nome.isEmpty() || email == null || email.isEmpty() || senha == null || senha.isEmpty()) {
                throw new IllegalArgumentException("[ERRO] Para criar um usuário, é necessário um nome, email e senha válidos.");
            }

            for (Usuario i : usuariosCadastrados) {
                if (i.email.equals(email)) {
                    throw new EmailDuplicadoException();
                }
            }

            this.nome = nome;
            this.email = email;
            this.senha = senha;
            usuariosCadastrados.add(this);
            System.out.println("Usuário cadastrado com sucesso.");

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }



    public boolean isLogado() {
        return logado;
    }

    public void logout() {
        if (logado) {
            logado = false;
            System.out.println("Usuário deslogado com sucesso.");
        } else {
            System.out.println("Usuário já está deslogado.");
        }
    }
}
