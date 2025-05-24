package com.zeroo8.quora.exception;

import org.springframework.http.HttpStatus;

public class InvalidUUIDFormatException extends CustomException {
    public InvalidUUIDFormatException(String message) {
        super(message, HttpStatus.BAD_REQUEST); // 400 Bad Request
    }
}
