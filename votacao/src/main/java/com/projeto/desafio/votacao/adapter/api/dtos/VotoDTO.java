package com.projeto.desafio.votacao.adapter.api.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class VotoDTO {
    private String voto;
    private SessaoVotacaoDTO sessaoVotacaoDTO;
    private PautaDTO dto;
}
