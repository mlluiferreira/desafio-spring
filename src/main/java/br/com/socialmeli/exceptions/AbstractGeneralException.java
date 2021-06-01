package br.com.socialmeli.exceptions;

import org.springframework.http.HttpStatus;

public class AbstractGeneralException extends RuntimeException {
    public Object requestData;

    public HttpStatus httpStatus;

    public AbstractGeneralException(String message, Object requestData, HttpStatus httpStatus) {
        super(message);
        this.requestData = requestData;
        this.httpStatus = httpStatus;
    }
}
