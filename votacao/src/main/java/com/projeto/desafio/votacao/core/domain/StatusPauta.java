package com.projeto.desafio.votacao.core.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum StatusPauta {
    APROVADA(1, "Aprovada"),
    NAO_APROVADA(2 ,"Não Aprovada"),
    PENDENTE_VOTACAO(3, "Pendente votação");

    private final Integer codigo;
    private final String descricao;

}
