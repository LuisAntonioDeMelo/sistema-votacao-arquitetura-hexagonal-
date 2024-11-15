package com.projeto.desafio.votacao.core.application.ports;

import com.projeto.desafio.votacao.core.domain.Voto;

public interface VotoRepositoryPort {
    boolean existsBySessaoAndAssociadoId(Long idSessao, Long idAssociado);
    Voto salvarVoto(Voto voto);
}
