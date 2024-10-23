package br.iesb.poo2024.aa2b1;

import br.iesb.poo2024.aa2b1.excecoes.EmailDuplicadoException;
import br.iesb.poo2024.aa2b1.excecoes.ValorLanceInvalidoException;

import java.time.LocalDateTime;

public class Main {

    /*
	 Instituição: IESB
	 Disciplina:  Programação Orientada a Objetos (POO)
	 Objetivo: 	  Trabalhar exceções.
	 Professor:   Bruno Miranda [bruno.marcos@iesb.edu.br]
	 Data:		  2024/25

	 # Prática: Atividade Avaliativa 1-B2 – Trabalhando com fluxos de exceção em Java aplicado ao seu estudo de caso
	 */

    public static void main(String[] args) throws Exception {

        System.out.println("Davi Serra Bezerra - 2312130031");
        System.out.println("POO2024 - 17/10/2024");

        System.out.println("\n========= Leiloeiro =========");
        // Crio um leiloeiro
        Leiloeiro guilherme = new Leiloeiro();
        guilherme.cadastrar("Guilherme", "guilherme@teste.com", "12345");

        Leiloeiro jose = new Leiloeiro();
        jose.cadastrar("Jose", "jose@teste.com", "12345");
        // Faz login
        jose.login("jose@teste.com", "12345");

        System.out.println("\n========= Participante Davi =========");
        // Crio um participante
        Participante davi = new Participante();
        davi.cadastrar("Davi", "davi@teste.com", "12345");
        // Faz login
        davi.login("davi@teste.com", "12345");

        System.out.println("\n========= Tentativa de Cadastrar Davi Novamente =========");
        // Tentativa de cadastrar novamente o mesmo participante
        Participante davi2 = new Participante();
        try {
            davi2.cadastrar("Davi", "davi@teste.com", "67890");
        } catch (EmailDuplicadoException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        //========= Participante com email nulo =========
        // Crio um participante com email nulo
        Participante david = new Participante();
        davi.cadastrar("David", null, "12345");

        System.out.println("\n========= Leilão =========");
        // Crio um leilão
        LocalDateTime agora = LocalDateTime.now();
        Leilao leilao = new Leilao(agora, agora.plusMinutes(30)); // Leilão com duração de 30 minutos
        leilao.adicionarItem(new Item("Dell G15 5520", "Com 1 ano de uso.", 100.00));

        // Tentativa de criar um leilão com data de início no passado
        LocalDateTime passado = agora.minusMinutes(10);
        Leilao leilao2 = new Leilao(passado, agora.plusMinutes(30));

        // Da início ao leilão
        guilherme.iniciarLeilao(leilao);
        jose.iniciarLeilao(leilao);

        System.out.println("\n========= Tentativa de Lance Abaixo de Zero =========");
//         Participante tenta dar um lance abaixo de zero
        try {
            Lance lanceNegativo = new Lance(-50.00, davi); // Lance com valor negativo
            Item itemLeiloado = leilao.getItens().get(0);
            itemLeiloado.registrarLance(leilao, lanceNegativo);
        } catch (ValorLanceInvalidoException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }

        System.out.println("\n========= Lance (Abaixo do Valor Mínimo) =========");
        // Participante dá um lance abaixo de valor mínimo
        Lance lance = new Lance(75.00, davi);
        Item itemLeiloado = leilao.getItens().get(0);
        itemLeiloado.registrarLance(leilao, lance);

        System.out.println("\n========= Primeiro Lance (Válido) =========");
        // Participante dá um lance válido
        Lance lance1 = new Lance(150.00, davi);
        itemLeiloado.registrarLance(leilao, lance1);

        System.out.println("\n========= Participante Maico =========");
        // Outro participante dá um lance
        Participante maico = new Participante();
        maico.cadastrar("Maico", "maico@teste.com", "12345");
        maico.login("maico@teste.com", "12345");

        System.out.println("\n========= Lance de Maico =========");
        Lance lance2 = new Lance(200.00, maico);
        itemLeiloado.registrarLance(leilao, lance2);

        System.out.println("\n========= Tentativa de Lance Menor =========");
        // Um participante tenta dar um lance menor
        Lance lance3 = new Lance(199.00, davi);
        itemLeiloado.registrarLance(leilao, lance3);

        System.out.println("\n========= Exemplo de exceção não tratada =========");
        // Tentar dar um lance com um participante sendo nulo
        Lance lance4 = new Lance(250.00, null);
        itemLeiloado.registrarLance(leilao, lance4);

        System.out.println("\n========= Encerramento do Leilão =========");
        // Encerra o leilão
        jose.encerrarLeilao(leilao);

        System.out.println("\n========= Declaração do Vencedor =========");
        // Declara o vencedor
        leilao.declaraVencedor();
    }
}