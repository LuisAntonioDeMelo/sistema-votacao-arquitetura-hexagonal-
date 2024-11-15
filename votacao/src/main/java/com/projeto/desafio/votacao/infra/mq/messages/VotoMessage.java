package com.projeto.desafio.votacao.infra.mq.messages;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
public class VotoMessage {
    private Long sessaoId;
    private Long associadoId;
    private Boolean opcaoVoto;
}
