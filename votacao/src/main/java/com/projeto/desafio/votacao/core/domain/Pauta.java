package com.projeto.desafio.votacao.core.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Pauta {

    private Long id;
    private String titulo;
    private String descricao;
    private StatusPauta statusPauta;

}
