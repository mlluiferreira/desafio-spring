package br.com.socialmeli.exceptions.user;

import br.com.socialmeli.exceptions.AbstractGeneralException;
import org.springframework.http.HttpStatus;

public class UserNotFoundException extends AbstractGeneralException {
    public UserNotFoundException(String message, Object requestData) {
        super(message, requestData, HttpStatus.BAD_REQUEST);
    }
}
