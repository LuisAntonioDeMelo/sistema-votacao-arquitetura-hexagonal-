package com.projeto.desafio.votacao.core.application.ports;

import com.projeto.desafio.votacao.adapter.api.dtos.ResultadoSessaoDTO;
import com.projeto.desafio.votacao.core.domain.SessaoVotacao;

public interface SessaoVotacaoServicePort {
    SessaoVotacao abrirVotacao(Long idPauta, Long duracaoMinutos);
    ResultadoSessaoDTO resultadoSessaoComVotos(Long pautaId);
}
