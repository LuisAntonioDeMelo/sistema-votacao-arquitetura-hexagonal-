package com.projeto.desafio.votacao.infra.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class VotingResultConsumer {

    @RabbitListener(queues = RabbitMQConfig.VOTING_QUEUE)
    public void consumeVotingResult(String message) {
        System.out.println("Mensagem recebida: " + message);
    }
}