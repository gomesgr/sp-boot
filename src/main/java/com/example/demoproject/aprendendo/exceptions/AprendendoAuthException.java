package com.example.demoproject.aprendendo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNAUTHORIZED)
public class AprendendoAuthException extends RuntimeException {

    public AprendendoAuthException(String message) {
        super(message);
    }
}
