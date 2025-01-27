package com.projeto.desafio.votacao.infra;

import com.projeto.desafio.votacao.core.application.service.exceptions.SessaoEncerradaException;
import com.projeto.desafio.votacao.core.application.service.exceptions.VotoExistenteException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;


@ControllerAdvice
@SuppressWarnings("ClassEscapesDefinedScope")
public class ExceptionHandlerAdvice {

    @Data
    @AllArgsConstructor
    private static class ErrorResponse{
        private int status;
        private String message;
        private LocalDateTime timestamp;
        private String details;
    }

    @ExceptionHandler({VotoExistenteException.class})
    public ResponseEntity<ErrorResponse> handleVotoExistenteException(
            VotoExistenteException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.ACCEPTED.value(),
                ex.getMessage(),
                LocalDateTime.now(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.ACCEPTED);
    }

    @ExceptionHandler({SessaoEncerradaException.class})
    public ResponseEntity<ErrorResponse> handleVotoExistenteException(
            SessaoEncerradaException ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.ACCEPTED.value(),
                ex.getMessage(),
                LocalDateTime.now(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.ACCEPTED);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGlobalException(Exception ex, WebRequest request) {
        ErrorResponse errorResponse = new ErrorResponse(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "An unexpected error occurred: " + ex.getMessage(),
                LocalDateTime.now(),
                request.getDescription(false)
        );
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}