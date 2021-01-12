package com.ecfghjp.training.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class TrainingNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	public TrainingNotFoundException(String message) {
        super(message);
    }
}
