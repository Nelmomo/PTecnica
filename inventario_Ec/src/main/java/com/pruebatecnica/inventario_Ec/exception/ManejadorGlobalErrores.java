package com.pruebatecnica.inventario_Ec.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
public class ManejadorGlobalErrores {

    @ExceptionHandler(ExceptionRecurso.class)
    public ResponseEntity<ErrorDetalle> manejarRecursoNoEncontrado(ExceptionRecurso ex, WebRequest request) {
        ErrorDetalle error = new ErrorDetalle(LocalDateTime.now(), ex.getMessage(), request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetalle> manejarErroresGenericos(Exception ex, WebRequest request) {
        ErrorDetalle error = new ErrorDetalle(LocalDateTime.now(), "Error interno del servidor", request.getDescription(false));
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
