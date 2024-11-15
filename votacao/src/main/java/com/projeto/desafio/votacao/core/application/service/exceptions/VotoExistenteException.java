package com.projeto.desafio.votacao.core.application.service.exceptions;

public class VotoExistenteException extends RuntimeException {
    public VotoExistenteException(String message) {
        super(message);
    }
}
