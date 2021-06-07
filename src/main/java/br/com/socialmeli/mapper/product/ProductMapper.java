package br.com.socialmeli.mapper.product;

import br.com.socialmeli.dtos.product.CreateProductDTO;
import br.com.socialmeli.dtos.product.ProductDTO;
import br.com.socialmeli.entities.product.Product;
import org.springframework.beans.BeanUtils;

public class ProductMapper {
    public static Product buildProduct(CreateProductDTO createProductDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(createProductDTO, product);
        return product;
    }

    public static ProductDTO buildProductDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(product, productDTO);
        return productDTO;
    }
}
