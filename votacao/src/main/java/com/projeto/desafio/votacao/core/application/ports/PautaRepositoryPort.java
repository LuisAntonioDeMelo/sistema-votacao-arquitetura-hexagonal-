package com.projeto.desafio.votacao.core.application.ports;

import com.projeto.desafio.votacao.core.domain.Pauta;

public interface PautaRepositoryPort {
    Pauta criarPauta(Pauta pauta);
}
