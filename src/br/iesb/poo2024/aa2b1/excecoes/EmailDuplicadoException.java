package br.iesb.poo2024.aa2b1.excecoes;

public class EmailDuplicadoException extends Exception {

        private static final String mensagemErro = "[ERRO] O e-mail informado já está cadastrado.";

        public EmailDuplicadoException() {
            super(mensagemErro);
        }
}
