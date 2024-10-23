package br.iesb.poo2024.aa2b1;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Leilao {
    private LocalDateTime dataHoraInicio;
    private LocalDateTime dataHoraFim;
    private String status;
    private List<Item> itens;

    public Leilao(LocalDateTime dataHoraInicio, LocalDateTime dataHoraFim) {
        try {
            if (dataHoraInicio == null || dataHoraFim == null || dataHoraInicio.isBefore(LocalDateTime.now()) || dataHoraFim.isBefore(dataHoraInicio)) {
                throw new IllegalArgumentException("[ERRO] Datas inválidas para o leilão.");
            }

            this.dataHoraInicio = dataHoraInicio;
            this.dataHoraFim = dataHoraFim;
            this.status = "Programado";
            this.itens = new ArrayList<>();
            System.out.println("Leilão criado com sucesso.");

        } catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public void iniciar(Leiloeiro leiloeiro) {
        try {
            if (leiloeiro.isLogado()) {
                this.status = "Ativo";
                System.out.println("Leilão iniciado!");
            } else {
                throw new IllegalStateException("[ERRO] O leiloeiro precisa estar logado para iniciar o leilão.");
            }
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
            e.printStackTrace();
        }
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

    public String getStatus() {
        return status;
    }

    public List<Item> getItens() {
        return itens;
    }
}
