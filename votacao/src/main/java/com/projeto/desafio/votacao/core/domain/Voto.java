package com.projeto.desafio.votacao.core.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Voto {
    private Long id;
    private SessaoVotacao sessao;
    private Long associadoId;
    private Boolean voto;
}
