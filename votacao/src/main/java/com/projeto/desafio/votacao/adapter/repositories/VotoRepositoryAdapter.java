package com.projeto.desafio.votacao.adapter.repositories;

import com.projeto.desafio.votacao.core.application.ports.VotoRepositoryPort;
import com.projeto.desafio.votacao.core.domain.Voto;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VotoRepositoryAdapter implements VotoRepositoryPort {

    private final ModelMapper modelMapper;
    private final VotoRepository votoRepository;

    @Override
    public boolean existsBySessaoAndAssociadoId(Long idSessao, Long idAssociado) {
        return false;
    }

    @Override
    public Voto salvarVoto(Voto voto) {
        return null;
    }
}
