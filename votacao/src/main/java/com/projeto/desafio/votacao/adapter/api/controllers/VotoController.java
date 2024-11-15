package com.projeto.desafio.votacao.adapter.api.controllers;

import com.projeto.desafio.votacao.adapter.api.dtos.StatusVotoDTO;
import com.projeto.desafio.votacao.core.application.ports.VotoServicePort;
import com.projeto.desafio.votacao.core.domain.Voto;
import com.projeto.desafio.votacao.infra.mq.VotoQueueProducer;
import com.projeto.desafio.votacao.infra.mq.messages.VotoMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/votos")
@RequiredArgsConstructor
public class VotoController {

    private final VotoServicePort votoServicePort;
    private final VotoQueueProducer votoQueueProducer;

    @GetMapping("/check-eligibilidade-voto")
    public StatusVotoDTO checkEligibility(@RequestParam String cpf) {
        return votoServicePort.checkVotingEligibility(cpf);
    }

    @PutMapping("votar-pauta")
    public ResponseEntity<?> votarPauta(Long sessaoId, Long associadoId, Boolean opcaoVoto) {
        StatusVotoDTO statusVoto = votoServicePort.registrarVoto(sessaoId,associadoId,opcaoVoto);
        return ResponseEntity.ok(statusVoto);
    }

    /*
        @Todo: votar pauta com fila para performace
     */
    @PutMapping("votar-pauta-queue")
    public ResponseEntity<?> votarPautaQueue(Long sessaoId, Long associadoId, Boolean opcaoVoto) {
        votoQueueProducer.send(new VotoMessage(sessaoId, associadoId, opcaoVoto));
        return ResponseEntity.accepted().body("Voto recebido e será processado");
    }
}
