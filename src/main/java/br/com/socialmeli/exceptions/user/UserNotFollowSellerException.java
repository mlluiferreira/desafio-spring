package br.com.socialmeli.exceptions.user;

import br.com.socialmeli.exceptions.AbstractGeneralException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class UserNotFollowSellerException extends AbstractGeneralException {
    public UserNotFollowSellerException(Object requestData) {
        super("user not follow the seller", requestData, BAD_REQUEST);
    }
}
