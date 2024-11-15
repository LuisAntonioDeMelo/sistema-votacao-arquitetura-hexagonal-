package com.projeto.desafio.votacao.core.application.ports;

import com.projeto.desafio.votacao.core.domain.SessaoVotacao;

import java.util.Optional;

public interface SessaoVotacaoRepositoryPort {

    public SessaoVotacao abrirVotacao(SessaoVotacao sessaoVotacao);
    public Optional<SessaoVotacao> findByPautaId(Long idPauta);
    public Optional<SessaoVotacao> findById(Long idSessao);
}
