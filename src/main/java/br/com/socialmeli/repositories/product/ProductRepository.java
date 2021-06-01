package br.com.socialmeli.repositories.product;

import br.com.socialmeli.entities.product.Product;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductRepository extends PagingAndSortingRepository<Product, Long> {
}
