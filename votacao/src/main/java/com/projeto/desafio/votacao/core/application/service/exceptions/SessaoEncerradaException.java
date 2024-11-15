package com.projeto.desafio.votacao.core.application.service.exceptions;

public class SessaoEncerradaException extends RuntimeException{

    public SessaoEncerradaException(String mensagem){
        super(mensagem);
    }
}
