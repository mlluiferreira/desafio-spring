package br.com.socialmeli.exceptions.user;

public class SellerNotFoundException extends UserNotFoundException{
    public SellerNotFoundException(Object requestData) {
        super("user seller not found", requestData);
    }
}
