package com.projeto.desafio.votacao.infra.mq;

import com.projeto.desafio.votacao.infra.mq.messages.VotoMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class VotoQueueProducer {

    private final RabbitTemplate rabbitTemplate;

    public void send(VotoMessage votoMessage) {
        rabbitTemplate.convertAndSend("votacao", votoMessage);
    }
}
