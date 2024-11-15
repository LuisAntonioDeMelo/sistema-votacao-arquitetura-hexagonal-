package com.projeto.desafio.votacao.adapter.api.dtos;

import lombok.Builder;
import lombok.Data;

@Builder
public class PautaDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private String status;
}
