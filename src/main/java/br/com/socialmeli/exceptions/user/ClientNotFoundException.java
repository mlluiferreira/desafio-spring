package br.com.socialmeli.exceptions.user;

public class ClientNotFoundException extends UserNotFoundException {
    public ClientNotFoundException(Object requestData) {
        super("user client not found", requestData);
    }
}
