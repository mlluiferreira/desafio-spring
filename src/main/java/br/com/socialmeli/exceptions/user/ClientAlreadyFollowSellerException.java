package br.com.socialmeli.exceptions.user;

import br.com.socialmeli.exceptions.AbstractGeneralException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

public class ClientAlreadyFollowSellerException extends AbstractGeneralException {
    public ClientAlreadyFollowSellerException(Object requestData) {
        super("client already follow the seller", requestData, BAD_REQUEST);
    }
}
