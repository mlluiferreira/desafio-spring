package br.com.socialmeli.exceptions.user;

import br.com.socialmeli.exceptions.AbstractGeneralException;
import org.springframework.http.HttpStatus;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class UserNotFollowSeller extends AbstractGeneralException {
    public UserNotFollowSeller(Object requestData) {
        super("user not follow the seller", requestData, BAD_REQUEST);
    }
}
