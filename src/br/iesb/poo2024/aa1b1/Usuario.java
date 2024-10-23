package br.iesb.poo2024.aa1b1;

public abstract class Usuario {
    protected String nome;
    protected String email;
    protected String senha;

    public abstract boolean login(String email, String senha);
    public abstract void cadastrar(String nome, String email, String senha);
}
