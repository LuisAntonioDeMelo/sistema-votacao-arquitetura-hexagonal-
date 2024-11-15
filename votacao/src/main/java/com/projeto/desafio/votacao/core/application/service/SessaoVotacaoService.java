package com.projeto.desafio.votacao.core.application.service;

import com.projeto.desafio.votacao.adapter.api.dtos.ResultadoSessaoDTO;
import com.projeto.desafio.votacao.core.application.ports.SessaoVotacaoServicePort;
import com.projeto.desafio.votacao.core.application.ports.SessaoVotacaoRepositoryPort;
import com.projeto.desafio.votacao.core.domain.SessaoVotacao;
import com.projeto.desafio.votacao.core.domain.Voto;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SessaoVotacaoService implements SessaoVotacaoServicePort {

    private final SessaoVotacaoRepositoryPort sessaoVotacaoRepositoryPort;

    public SessaoVotacaoService(SessaoVotacaoRepositoryPort sessaoVotacaoRepositoryPort) {
        this.sessaoVotacaoRepositoryPort = sessaoVotacaoRepositoryPort;
    }

    public SessaoVotacao abrirVotacao(Long pautaId, Long duracaoMinutos) {
        SessaoVotacao sessao = new SessaoVotacao();
        sessao.setInicio(LocalDateTime.now());
        sessao.setFim(LocalDateTime.now().plusMinutes(duracaoMinutos != null ? duracaoMinutos : 1));
        return sessaoVotacaoRepositoryPort.abrirVotacao(sessao);
    }

    public ResultadoSessaoDTO resultadoSessaoComVotos(Long pautaId) {

        SessaoVotacao sessao = sessaoVotacaoRepositoryPort.findByPautaId(pautaId)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));

        List<Voto> votos = sessao.getVotos();

        long votosSim = votos.stream().filter(Voto::getVoto).count();
        long votosNao = votos.size() - votosSim;

        Map<String, Long> resultado = new HashMap<>();
        resultado.put("Sim", votosSim);
        resultado.put("Não", votosNao);

        return getResultadoSessaoDTO(pautaId, sessao, resultado);
    }

    private static ResultadoSessaoDTO getResultadoSessaoDTO(Long pautaId, SessaoVotacao sessao, Map<String, Long> resultado) {
        ResultadoSessaoDTO resultadoSessaoDTO = new ResultadoSessaoDTO();
        resultadoSessaoDTO.setSessaoVotacao(sessao);
        resultadoSessaoDTO.setIdPauta(pautaId);
        resultadoSessaoDTO.setResultadoDeVotos(resultado);
        return resultadoSessaoDTO;
    }
}
