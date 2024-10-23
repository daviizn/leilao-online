package br.iesb.poo2024.aa1b1;

import java.time.LocalDateTime;

public class Main {

    /*
	 Instituição: IESB
	 Disciplina:  Programação Orientada a Objetos (POO)
	 Objetivo: 	  Fazer um sistema de leilão online.
	 Professor:   Bruno Miranda [bruno.marcos@iesb.edu.br]
	 Data:		  2024/25

	 # Prática: Atividade Avaliativa 1-B1 – Modelagem negocial orientada a objetos e implementação de um caso de uso em Java
	 */

    public static void main(String[] args) {

        System.out.println("Davi Serra Bezerra - 2312130031");
        System.out.println("POO2024 - 17/09/2024");

        System.out.println("\n========= Leiloeiro =========");
        // Crio um leiloeiro
        Leiloeiro guilherme = new Leiloeiro();
        guilherme.cadastrar("Guilherme", "guilherme@teste.com", "12345");
        // Faz login
        guilherme.login("guilherme@teste.com", "12345");

        System.out.println("\n========= Participante Davi =========");
        // Crio um participante
        Participante davi = new Participante();
        davi.cadastrar("Davi", "davi@teste.com", "12345");
        // Faz login
        davi.login("davi@teste.com", "12345");

        System.out.println("\n========= Leilão =========");
        // Crio um leilão
        LocalDateTime agora = LocalDateTime.now();
        Leilao leilao = new Leilao(agora, agora.plusMinutes(30)); // Leilão com duração de 30 minutos
        leilao.adicionarItem(new Item("Dell G15 5520", "Com 1 ano de uso.", 100.00));

        // Da início ao leilão
        guilherme.iniciarLeilao(leilao);
        System.out.println("Leilão iniciado!");

        System.out.println("\n========= Primeiro Lance (Abaixo do Valor Mínimo) =========");
        // Participante dá um lance abaixo de valor mínimo
        Lance lance = new Lance(75.00, davi);
        Item itemLeiloado = leilao.getItens().get(0);
        itemLeiloado.registrarLance(lance);

        System.out.println("\n========= Segundo Lance (Válido) =========");
        // Participante dá um lance válido
        Lance lance1 = new Lance(150.00, davi);
        itemLeiloado.registrarLance(lance1);

        System.out.println("\n========= Participante Maico =========");
        // Outro participante dá um lance
        Participante maico = new Participante();
        maico.cadastrar("Maico", "maico@teste.com", "12345");
        maico.login("maico@teste.com", "12345");

        System.out.println("\n========= Lance de Maico =========");
        Lance lance2 = new Lance(200.00, maico);
        itemLeiloado.registrarLance(lance2);

        System.out.println("\n========= Tentativa de Lance Menor =========");
        // Um participante tenta dar um lance menor
        Lance lance3 = new Lance(199.00, davi);
        itemLeiloado.registrarLance(lance3);

        System.out.println("\n========= Encerramento do Leilão =========");
        // Encerra o leilão
        guilherme.encerrarLeilao(leilao);

        System.out.println("\n========= Declaração do Vencedor =========");
        // Declara o vencedor
        leilao.declaraVencedor();
    }
}