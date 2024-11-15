package com.projeto.desafio.votacao.adapter.converters;

import com.projeto.desafio.votacao.adapter.api.dtos.PautaDTO;
import com.projeto.desafio.votacao.adapter.api.dtos.PautaRequest;
import com.projeto.desafio.votacao.core.domain.Pauta;
import org.springframework.stereotype.Component;

@Component
public class PautaConverter {

    public Pauta toDomain(PautaRequest pautaRequest){
        Pauta pauta = new Pauta();
        pauta.setTitulo(pautaRequest.titulo());
        pauta.setDescricao(pautaRequest.descricao());
        return pauta;
    }

    public PautaDTO toDto(Pauta pauta) {
        return PautaDTO.builder()
                .titulo(pauta.getTitulo())
                .descricao(pauta.getDescricao())
                .status(pauta.getStatusPauta().getDescricao())
                .build();
    }
}
