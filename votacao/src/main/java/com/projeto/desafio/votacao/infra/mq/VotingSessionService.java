package com.projeto.desafio.votacao.infra.mq;

import org.springframework.stereotype.Service;

@Service
public class VotingSessionService {

    private final VotingResultPublisher votingResultPublisher;

    public VotingSessionService(VotingResultPublisher votingResultPublisher) {
        this.votingResultPublisher = votingResultPublisher;
    }

    public void sendVotingSession(Long pautaId) {
        votingResultPublisher.publishVotingResult(pautaId);
    }
}