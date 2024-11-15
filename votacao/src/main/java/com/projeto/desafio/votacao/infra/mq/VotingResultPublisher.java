package com.projeto.desafio.votacao.infra.mq;

import com.projeto.desafio.votacao.adapter.api.dtos.ResultadoSessaoDTO;
import com.projeto.desafio.votacao.core.application.ports.SessaoVotacaoServicePort;
import com.projeto.desafio.votacao.core.application.service.SessaoVotacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VotingResultPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final SessaoVotacaoServicePort sessaoVotacaoServicePort;

    public void publishVotingResult(Long pautaId) {
        ResultadoSessaoDTO resultadoSessaoDTO = sessaoVotacaoServicePort.resultadoSessaoComVotos(pautaId);
        rabbitTemplate.convertAndSend(RabbitMQConfig.VOTING_EXCHANGE, "voting.result", resultadoSessaoDTO);
        System.out.println("Mensagem publicada: " + resultadoSessaoDTO.toString());
    }
}