package br.com.socialmeli.controllers;

import br.com.socialmeli.dtos.ErrorInfoDTO;
import br.com.socialmeli.exceptions.AbstractGeneralException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ExceptionHandlerController {
    @ExceptionHandler(AbstractGeneralException.class)
    public ResponseEntity<ErrorInfoDTO> catchExceptions(HttpServletRequest req, Exception exception) {
        ErrorInfoDTO errorInfo = ErrorInfoDTO.create(req, exception);
        return new ResponseEntity<>(errorInfo, errorInfo.statusCode);
    }
}
