package com.zeroo8.quora.exception;

import org.springframework.http.HttpStatus;

public class EmailAlreadyExistsException extends CustomException {
    public EmailAlreadyExistsException(String message) {
        super(message, HttpStatus.CONFLICT); // 409 Conflict
    }
}

