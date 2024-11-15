package com.projeto.desafio.votacao.adapter.api.dtos;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class StatusVotoDTO {
    private String status;
    private LocalDateTime dataVotacao;

    public StatusVotoDTO(){
        this.dataVotacao = LocalDateTime.now();
    }
}
