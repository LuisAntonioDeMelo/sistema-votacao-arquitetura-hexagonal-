package com.projeto.desafio.votacao.infra;

import com.projeto.desafio.votacao.core.application.ports.*;
import com.projeto.desafio.votacao.core.application.service.PautaService;
import com.projeto.desafio.votacao.core.application.service.SessaoVotacaoService;
import com.projeto.desafio.votacao.core.application.service.VotoService;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanFactory {

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public SessaoVotacaoServicePort sessaoVotacaoServicePort(SessaoVotacaoRepositoryPort sessaoVotacaoRepositoryPort){
        return new SessaoVotacaoService(sessaoVotacaoRepositoryPort);
    }

    @Bean
    public PautaServicePort pautaServicePort(PautaRepositoryPort pautaRepositoryPort) {
        return new PautaService(pautaRepositoryPort);
    }

    @Bean
    public VotoServicePort votoServicePort(VotoRepositoryPort votoRepositoryPort, SessaoVotacaoRepositoryPort sessaoVotacaoRepositoryPort) {
        return new VotoService(votoRepositoryPort, sessaoVotacaoRepositoryPort);
    }
}
