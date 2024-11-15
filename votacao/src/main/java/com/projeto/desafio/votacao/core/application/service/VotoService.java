package com.projeto.desafio.votacao.core.application.service;

import com.projeto.desafio.votacao.adapter.api.dtos.StatusVotoDTO;
import com.projeto.desafio.votacao.core.application.ports.SessaoVotacaoRepositoryPort;
import com.projeto.desafio.votacao.core.application.ports.VotoRepositoryPort;
import com.projeto.desafio.votacao.core.application.ports.VotoServicePort;
import com.projeto.desafio.votacao.core.application.service.exceptions.SessaoEncerradaException;
import com.projeto.desafio.votacao.core.application.service.exceptions.VotoExistenteException;
import com.projeto.desafio.votacao.core.domain.SessaoVotacao;
import com.projeto.desafio.votacao.core.domain.Voto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;

@Slf4j
public class VotoService implements VotoServicePort {

    private static final String API_URL = "https://user-info.herokuapp.com/users/";
    private final VotoRepositoryPort votoRepositoryPort;
    private final SessaoVotacaoRepositoryPort sessaoVotacaoRepositoryPort;

    public VotoService(VotoRepositoryPort votoRepositoryPort, SessaoVotacaoRepositoryPort sessaoVotacaoRepositoryPort) {
        this.votoRepositoryPort = votoRepositoryPort;
        this.sessaoVotacaoRepositoryPort = sessaoVotacaoRepositoryPort;
    }

    @Override
    public StatusVotoDTO registrarVoto(Long sessaoId, Long associadoId, Boolean voto) {
        SessaoVotacao sessao = sessaoVotacaoRepositoryPort.findById(sessaoId)
                .orElseThrow(() -> new RuntimeException("Sessão não encontrada"));

        if (LocalDateTime.now().isAfter(sessao.getFim())) {
            throw new SessaoEncerradaException("Sessão de votação encerrada");
        }

        boolean jaVotou = votoRepositoryPort.existsBySessaoAndAssociadoId(sessao.getId(), associadoId);
        if (jaVotou) {
            throw new VotoExistenteException("Associado já votou nesta pauta");
        }

        return salvarVoto(associadoId, voto, sessao);
    }

    private StatusVotoDTO salvarVoto(Long associadoId, Boolean voto, SessaoVotacao sessao) {
        Voto novoVoto = new Voto();
        novoVoto.setSessao(sessao);
        novoVoto.setAssociadoId(associadoId);
        novoVoto.setVoto(voto);

        StatusVotoDTO statusVotoDTO = new StatusVotoDTO();
        try {
            votoRepositoryPort.salvarVoto(novoVoto);
        }
        catch (Exception e) {
            log.error("Voto não foi salvo " + e.getMessage());
            statusVotoDTO.setStatus("Voto não Resgistrado!");
            return statusVotoDTO;
        }
        statusVotoDTO.setStatus("Voto registrado!");
        return statusVotoDTO;
    }

    @Override
    public StatusVotoDTO checkVotingEligibility(String cpf) {
        RestTemplate restTemplate = new RestTemplate();
        try {
            StatusVotoDTO statusVotoDTO = restTemplate.getForObject(API_URL + cpf, StatusVotoDTO.class);
            if (statusVotoDTO == null || statusVotoDTO.getStatus() == null) {
                throw new IllegalStateException("Resposta inesperada da API.");
            }
            return statusVotoDTO;

        } catch (HttpClientErrorException.NotFound e) {
            throw new IllegalArgumentException("CPF inválido ou não encontrado.", e);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao verificar elegibilidade de voto.", e);
        }
    }
}
