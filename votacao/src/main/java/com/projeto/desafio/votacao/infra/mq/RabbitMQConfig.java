package com.projeto.desafio.votacao.infra.mq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfig {

    public static final String VOTING_QUEUE = "votingResultsQueue";
    public static final String VOTING_EXCHANGE = "votingExchange";

    @Bean
    public Queue votingQueue() {
        return new Queue(VOTING_QUEUE, false);
    }

    @Bean
    public TopicExchange votingExchange() {
        return new TopicExchange(VOTING_EXCHANGE);
    }

    @Bean
    public Binding binding(Queue votingQueue, TopicExchange votingExchange) {
        return BindingBuilder.bind(votingQueue).to(votingExchange).with("voting.result");
    }
}