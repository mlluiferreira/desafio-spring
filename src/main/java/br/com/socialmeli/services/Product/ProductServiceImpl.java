package br.com.socialmeli.services.Product;

import br.com.socialmeli.dtos.product.CreateProductDTO;
import br.com.socialmeli.dtos.product.ProductDTO;
import br.com.socialmeli.entities.product.Product;
import br.com.socialmeli.mapper.product.ProductMapper;
import br.com.socialmeli.repositories.product.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDTO save(CreateProductDTO createProductDTO) {
        Product product = ProductMapper.buildProduct(createProductDTO);
        product = productRepository.save(product);
        return ProductMapper.buildProductDTO(product);
    }

    @Override
    public Optional<ProductDTO> findById(Long productId) {
        Optional<Product> productOp = productRepository.findById(productId);
        if (productOp.isEmpty()) return Optional.empty();
        ProductDTO productDTO = ProductMapper.buildProductDTO(productOp.get());
        return Optional.of(productDTO);
    }
}
