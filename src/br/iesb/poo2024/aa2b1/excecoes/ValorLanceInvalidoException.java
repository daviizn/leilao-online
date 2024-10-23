package br.iesb.poo2024.aa2b1.excecoes;

public class ValorLanceInvalidoException extends Exception {

    private static String mensagemErro = "[ERRO] O valor do lance deve ser maior que zero.";

    public ValorLanceInvalidoException() {
        super(mensagemErro);
    }
}
