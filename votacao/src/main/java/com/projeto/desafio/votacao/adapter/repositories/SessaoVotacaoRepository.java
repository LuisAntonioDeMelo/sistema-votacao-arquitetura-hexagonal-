package com.projeto.desafio.votacao.adapter.repositories;

import com.projeto.desafio.votacao.adapter.persistences.SessaoVotacaoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SessaoVotacaoRepository extends JpaRepository<SessaoVotacaoEntity, Long> {
    Optional<SessaoVotacaoEntity> findByPautaId(Long idPauta);
}
