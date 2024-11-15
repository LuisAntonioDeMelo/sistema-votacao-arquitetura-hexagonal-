package com.projeto.desafio.votacao.adapter.persistences;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class VotoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "sessao_id")
    private SessaoVotacaoEntity sessao;

    private Long associadoId;

    private Boolean voto;
}