package br.iesb.poo2024.aa1b1;

import java.time.LocalDateTime;

public class Lance {
    private double valor;
    private LocalDateTime dataHora;
    private Participante participante;

    public Lance(double valor, Participante participante) {
        this.valor = valor;
        this.dataHora = LocalDateTime.now();
        this.participante = participante;
    }

    public Participante getParticipante() {
        return participante;
    }

    public double getValor() {
        return valor;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }
}