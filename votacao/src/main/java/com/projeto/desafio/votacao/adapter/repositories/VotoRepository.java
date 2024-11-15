package com.projeto.desafio.votacao.adapter.repositories;

import com.projeto.desafio.votacao.adapter.persistences.VotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VotoRepository extends JpaRepository<VotoEntity,Long> {
}
