package com.projeto.desafio.votacao.core.application.service;

import com.projeto.desafio.votacao.core.application.ports.PautaRepositoryPort;
import com.projeto.desafio.votacao.core.application.ports.PautaServicePort;
import com.projeto.desafio.votacao.core.domain.Pauta;

public class PautaService implements PautaServicePort {

    private final PautaRepositoryPort pautaRepositoryPort;

    public PautaService(PautaRepositoryPort pautaRepositoryPort) {
        this.pautaRepositoryPort = pautaRepositoryPort;
    }


    @Override
    public Pauta criarPauta(Pauta pauta) {
        return pautaRepositoryPort.criarPauta(pauta);
    }
}
