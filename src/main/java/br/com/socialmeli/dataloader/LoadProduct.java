package br.com.socialmeli.dataloader;

import br.com.socialmeli.dtos.product.CreateProductDTO;
import br.com.socialmeli.services.Product.ProductService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class LoadProduct implements ApplicationRunner {

    private final ProductService productService;

    public LoadProduct(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        loadProducts();
    }

    public void loadProducts() {
        CreateProductDTO[] productDTOS = {
                new CreateProductDTO("teste", "testando", "marca", "roxo", "oshentea"),
                new CreateProductDTO("maracota", "testando", "marca", "roxo", "oshenteb"),
                new CreateProductDTO("blabla", "testando", "marca", "roxo", "oshentec"),
                new CreateProductDTO("foooo", "testando", "marca", "roxo", "oshented"),
                new CreateProductDTO("boooo", "testando", "marca", "roxo", "oshentee"),
        };

        Arrays.stream(productDTOS).forEach(productService::save);
    }
}
