package com.projeto.desafio.votacao.adapter.persistences;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
public class SessaoVotacaoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "pauta_id")
    private PautaEntity pauta;

    private LocalDateTime inicio;
    private LocalDateTime fim;

    @OneToMany(mappedBy = "sessao")
    private List<VotoEntity> votos;

}
