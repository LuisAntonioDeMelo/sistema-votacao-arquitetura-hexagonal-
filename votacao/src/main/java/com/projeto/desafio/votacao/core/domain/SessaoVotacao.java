package com.projeto.desafio.votacao.core.domain;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
public class SessaoVotacao {

    private Long id;
    private Pauta pauta;
    private LocalDateTime inicio;
    private LocalDateTime fim;
    private List<Voto> votos;
}
