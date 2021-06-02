package br.com.socialmeli.controllers;

import br.com.socialmeli.dtos.post.CreatePostDTO;
import br.com.socialmeli.dtos.post.PostDTO;
import br.com.socialmeli.dtos.product.CreateProductDTO;
import br.com.socialmeli.dtos.product.ProductDTO;
import br.com.socialmeli.services.Product.ProductService;
import br.com.socialmeli.services.post.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {

    private final ProductService productService;

    private final PostService postService;

    public ProductController(ProductService productService, PostService postService) {
        this.productService = productService;
        this.postService = postService;
    }

    // REQ PARA - 0005
    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody CreateProductDTO createProductDTO) {
        return ResponseEntity.ok(productService.save(createProductDTO));
    }

    // 0005
    @PostMapping("/newpost")
    public ResponseEntity<PostDTO> createPost(@RequestBody CreatePostDTO createPostDTO) {
        return ResponseEntity.ok(postService.createPost(createPostDTO));
    }
}
