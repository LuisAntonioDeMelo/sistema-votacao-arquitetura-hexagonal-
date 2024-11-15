package com.projeto.desafio.votacao.adapter.api.controllers;

import com.projeto.desafio.votacao.adapter.api.dtos.PautaDTO;
import com.projeto.desafio.votacao.adapter.api.dtos.PautaRequest;
import com.projeto.desafio.votacao.adapter.converters.PautaConverter;
import com.projeto.desafio.votacao.core.application.ports.PautaServicePort;
import com.projeto.desafio.votacao.core.domain.Pauta;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/pautas")
@RequiredArgsConstructor
public class PautaController {

    private final PautaServicePort pautaServicePort;
    private final PautaConverter pautaConverter;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<PautaDTO> criarPauta(@RequestBody PautaRequest pautaRequest) {
        Pauta pauta = pautaServicePort.criarPauta(pautaConverter.toDomain(pautaRequest));
        return ResponseEntity.ok(pautaConverter.toDto(pauta));
    }
}
