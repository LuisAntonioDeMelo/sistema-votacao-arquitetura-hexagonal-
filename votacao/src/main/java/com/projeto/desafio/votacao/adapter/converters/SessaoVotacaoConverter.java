package com.projeto.desafio.votacao.adapter.converters;

import com.projeto.desafio.votacao.adapter.api.dtos.SessaoVotacaoDTO;
import com.projeto.desafio.votacao.core.domain.SessaoVotacao;
import org.springframework.stereotype.Component;

@Component
public class SessaoVotacaoConverter {

    public SessaoVotacaoDTO toDto(SessaoVotacao sessaoVotacao) {
        return SessaoVotacaoDTO
                .builder()
                .build();
    }
}
