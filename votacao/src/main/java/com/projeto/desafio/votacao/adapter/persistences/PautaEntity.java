package com.projeto.desafio.votacao.adapter.persistences;

import com.projeto.desafio.votacao.core.domain.StatusPauta;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class PautaEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;

    @Enumerated(EnumType.ORDINAL)
    private StatusPauta statusPauta;

}
