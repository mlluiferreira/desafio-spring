package br.com.socialmeli.services.Product;

import br.com.socialmeli.dtos.product.CreateProductDTO;
import br.com.socialmeli.dtos.product.ProductDTO;
import br.com.socialmeli.entities.product.Product;
import br.com.socialmeli.repositories.product.ProductRepository;
import br.com.socialmeli.services.user.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    private final UserService userService;

    public ProductServiceImpl(ProductRepository productRepository, UserService userService) {
        this.productRepository = productRepository;
        this.userService = userService;
    }

    @Override
    public ProductDTO save(CreateProductDTO createProductDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(createProductDTO, product);
        product = productRepository.save(product);
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }

    @Override
    public Optional<ProductDTO> findById(Long productId) {
        Optional<Product> productOp = productRepository.findById(productId);
        if (productOp.isEmpty()) return Optional.empty();
        Product product = productOp.get();
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return Optional.of(productDTO);
    }
}
