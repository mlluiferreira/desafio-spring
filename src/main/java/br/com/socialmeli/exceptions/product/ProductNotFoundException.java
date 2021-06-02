package br.com.socialmeli.exceptions.product;

import br.com.socialmeli.exceptions.AbstractGeneralException;
import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends AbstractGeneralException {
    public ProductNotFoundException(Object requestData) {
        super("product not found", requestData, HttpStatus.BAD_REQUEST);
    }
}
