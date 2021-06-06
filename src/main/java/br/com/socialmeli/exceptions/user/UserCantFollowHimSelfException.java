package br.com.socialmeli.exceptions.user;

import br.com.socialmeli.exceptions.AbstractGeneralException;
import org.springframework.http.HttpStatus;

public class UserCantFollowHimSelfException extends AbstractGeneralException {
    public UserCantFollowHimSelfException(Object requestData) {
        super("user cannot follow himself", requestData, HttpStatus.BAD_REQUEST);
    }
}
