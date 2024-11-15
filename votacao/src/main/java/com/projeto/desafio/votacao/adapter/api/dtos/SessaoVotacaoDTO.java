package com.projeto.desafio.votacao.adapter.api.dtos;

import com.projeto.desafio.votacao.adapter.persistences.PautaEntity;
import com.projeto.desafio.votacao.adapter.persistences.VotoEntity;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class SessaoVotacaoDTO {

    private Long id;
    private PautaDTO pauta;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private List<VotoDTO> votos;
}
