package com.projeto.desafio.votacao.adapter.repositories;

import com.projeto.desafio.votacao.adapter.persistences.PautaEntity;
import com.projeto.desafio.votacao.core.application.ports.PautaRepositoryPort;
import com.projeto.desafio.votacao.core.domain.Pauta;
import com.projeto.desafio.votacao.core.domain.StatusPauta;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PautaRepositoryAdapter implements PautaRepositoryPort {

    private final PautaRepository pautaRepository;
    private final ModelMapper modelMapper;

    @Override
    public Pauta criarPauta(Pauta pauta) {
        PautaEntity pautaEntity = modelMapper.map(pauta, PautaEntity.class);
        pautaEntity.setStatusPauta(StatusPauta.PENDENTE_VOTACAO);
        PautaEntity pautaSaved = pautaRepository.save(pautaEntity);
        return modelMapper.map(pautaSaved, Pauta.class);
    }
}
