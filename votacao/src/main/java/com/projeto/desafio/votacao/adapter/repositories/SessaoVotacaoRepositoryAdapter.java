package com.projeto.desafio.votacao.adapter.repositories;

import com.projeto.desafio.votacao.adapter.persistences.SessaoVotacaoEntity;
import com.projeto.desafio.votacao.core.application.ports.SessaoVotacaoRepositoryPort;
import com.projeto.desafio.votacao.core.domain.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class SessaoVotacaoRepositoryAdapter implements SessaoVotacaoRepositoryPort {

    private final SessaoVotacaoRepository sessaoVotacaoRepository;
    private final ModelMapper modelMapper;

    @Override
    public SessaoVotacao abrirVotacao(SessaoVotacao sessaoVotacao) {
        SessaoVotacaoEntity entity = modelMapper.map(sessaoVotacao, SessaoVotacaoEntity.class);
        entity = sessaoVotacaoRepository.save(entity);
        return modelMapper.map(entity, SessaoVotacao.class);
    }

    @Override
    public Optional<SessaoVotacao> findByPautaId(Long idPauta) {
        Optional<SessaoVotacaoEntity> sessaoVotacaoEntity = sessaoVotacaoRepository.findByPautaId(idPauta);
        return sessaoVotacaoEntity.map(entity -> modelMapper.map(entity, SessaoVotacao.class));
    }

    @Override
    public Optional<SessaoVotacao> findById(Long idSessao) {
        Optional<SessaoVotacaoEntity> sessaoVotacaoEntity = sessaoVotacaoRepository.findById(idSessao);
        return sessaoVotacaoEntity.map(entity -> modelMapper.map(entity, SessaoVotacao.class));
    }
}
