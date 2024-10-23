package br.iesb.poo2024.aa2b1;

import java.util.ArrayList;
import java.util.List;

public class Item {
    private String nome;
    private String descricao;
    private double valorMinimo;
    private List<Lance> lances;

    public Item(String nome, String descricao, double valorMinimo) {
        this.nome = nome;
        this.descricao = descricao;
        this.valorMinimo = valorMinimo;
        this.lances = new ArrayList<>();
    }

    public void registrarLance(Leilao leilao, Lance lance) {

        if (!leilao.getStatus().equals("Ativo")) {
            System.out.println("Não é possível registrar um lance, o leilão não está ativo.");
            return;
        }

        Lance maiorLance = getMaiorLance();

        if (lance.getValor() >= valorMinimo ) {

            if (maiorLance == null || lance.getValor() > maiorLance.getValor()) {
                lances.add(lance);
                System.out.println("Lance de " + lance.getValor() + " dado por " + lance.getParticipante().nome);
                System.out.println("Lance de " + lance.getValor() + " registrado para o item '" + nome + "'");
            } else {
                System.out.println("Lance deve ser maior que o maior lance registrado para o item '" + nome + "'");
            }
        } else {
            System.out.println("Lance abaixo do valor mínimo para o item '" + nome + "'");
        }
    }

    public Lance getMaiorLance() {

        if (lances.isEmpty()) {
            return null;
        }
        Lance maiorLance = lances.get(0);

        for (Lance lance : lances) {
            if (lance.getValor() > maiorLance.getValor()) {
                maiorLance = lance;
            }
        }

        return maiorLance;
    }

    public String getNome() {
        return nome;
    }
}
