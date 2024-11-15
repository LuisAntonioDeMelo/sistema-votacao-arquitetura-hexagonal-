package com.projeto.desafio.votacao.adapter.repositories;

import com.projeto.desafio.votacao.adapter.persistences.PautaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PautaRepository extends JpaRepository<PautaEntity, Long> {
}
