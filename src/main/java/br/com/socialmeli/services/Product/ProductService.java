package br.com.socialmeli.services.Product;

import br.com.socialmeli.dtos.product.CreateProductDTO;
import br.com.socialmeli.dtos.product.ProductDTO;

import java.util.Optional;

public interface ProductService {
    ProductDTO save(CreateProductDTO createProductDTO);

    Optional<ProductDTO> findById(Long productId);
}
