package com.gulteking.wsdemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.UNAUTHORIZED)
public class InvalidLoginException extends AuthenticationException {
    public InvalidLoginException(String msg) {
        super(msg);
    }
}
