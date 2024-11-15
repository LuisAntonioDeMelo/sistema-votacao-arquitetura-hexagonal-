package com.projeto.desafio.votacao.adapter.api.dtos;

import com.projeto.desafio.votacao.core.domain.SessaoVotacao;
import lombok.Data;

import java.util.Map;

@Data
public class ResultadoSessaoDTO {
    private SessaoVotacao sessaoVotacao;
    private Long idPauta;
    private Map<String, Long> resultadoDeVotos;
}
