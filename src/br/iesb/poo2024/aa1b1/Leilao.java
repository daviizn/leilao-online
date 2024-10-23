package br.iesb.poo2024.aa1b1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Leilao {
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String status;
    private List<Item> itens;

    public Leilao(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
        this.dataHoraInicio = dataHoraInicio;
        this.dataHoraFim = dataHoraFim;
        this.status = "Programado";
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void iniciar() {
        this.status = "Ativo";
    }

    public void encerrar() {
        this.status = "Encerrado";
    }

    public void declaraVencedor() {
        for (Item item : itens) {
            Lance maiorLance = item.getMaiorLance();
            if (maiorLance != null) {
                System.out.println("O vencedor do item '" + item.getNome() + "' é " + maiorLance.getParticipante().getNome() + " com um lance de " + maiorLance.getValor());
            } else {
                System.out.println("Nenhum lance foi feito para o item '" + item.getNome() + "'.");
            }
        }
    }

    public List<Item> getItens() {
        return itens;
    }
}