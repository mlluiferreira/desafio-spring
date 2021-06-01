package br.com.socialmeli.services.Product;

import br.com.socialmeli.dtos.product.CreateProductDTO;
import br.com.socialmeli.dtos.product.ProductDTO;

public interface ProductService {
    ProductDTO save(CreateProductDTO createProductDTO);
}
