package com.projeto.desafio.votacao.adapter.api.controllers;

import com.projeto.desafio.votacao.adapter.api.dtos.SessaoVotacaoDTO;
import com.projeto.desafio.votacao.adapter.converters.SessaoVotacaoConverter;
import com.projeto.desafio.votacao.core.application.ports.SessaoVotacaoServicePort;
import com.projeto.desafio.votacao.core.domain.SessaoVotacao;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sessoes")
@RequiredArgsConstructor
public class SessaoVotacaoController {

    private final SessaoVotacaoServicePort sessaoVotacaoServicePort;
    private final SessaoVotacaoConverter sessaoVotacaoConverter;

    @PostMapping("/abrir")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<SessaoVotacaoDTO> abrirSessao(
            @RequestParam Long pautaId,
            @RequestParam(required = false) Long duracaoMinutos
    ) {
        SessaoVotacao sessaoVotacao =  sessaoVotacaoServicePort.abrirVotacao(pautaId, duracaoMinutos);
        return ResponseEntity.ok(sessaoVotacaoConverter.toDto(sessaoVotacao));
    }


}
