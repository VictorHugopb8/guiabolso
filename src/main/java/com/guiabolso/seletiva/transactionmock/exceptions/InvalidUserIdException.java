package com.guiabolso.seletiva.transactionmock.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.ResourceBundle;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class InvalidUserIdException extends Exception {

    public InvalidUserIdException() {
        super(ResourceBundle.getBundle("messages").getString("com.guiabolso.userId.invalid"));
    }

}
