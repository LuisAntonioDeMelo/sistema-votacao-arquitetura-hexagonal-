package com.projeto.desafio.votacao.core.application.ports;

import com.projeto.desafio.votacao.adapter.api.dtos.StatusVotoDTO;
import com.projeto.desafio.votacao.core.domain.Voto;

public interface VotoServicePort {
    StatusVotoDTO registrarVoto(Long sessaoId, Long associadoId, Boolean voto);
    StatusVotoDTO checkVotingEligibility(String cpf);
}
