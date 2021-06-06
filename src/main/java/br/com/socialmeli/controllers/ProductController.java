package br.com.socialmeli.controllers;

import br.com.socialmeli.dtos.SortParam;
import br.com.socialmeli.dtos.post.CreatePromoPostDTO;
import br.com.socialmeli.dtos.post.CreateRegularPostDTO;
import br.com.socialmeli.dtos.post.PostFromSellerByClientDTO;
import br.com.socialmeli.dtos.post.PostPromoCountDTO;
import br.com.socialmeli.dtos.post.PostPromoListDTO;
import br.com.socialmeli.dtos.product.CreateProductDTO;
import br.com.socialmeli.dtos.product.ProductDTO;
import br.com.socialmeli.services.Product.ProductService;
import br.com.socialmeli.services.post.PostService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    public ResponseEntity<?> createPost(@RequestBody CreateRegularPostDTO createRegularPostDTO) {
        postService.createPost(createRegularPostDTO);
        return ResponseEntity.ok().build();
    }

    // 0006 0009
    @GetMapping("/followed/{userId}/list")
    public ResponseEntity<PostFromSellerByClientDTO> postListOfSellerThatUserFollow(@PathVariable("userId") Long userId, SortParam sort) {
        return ResponseEntity.ok(postService.postListOfSellerThaClientFollowBetweenLastTwoWeeksAndOrderedByDateDesc(userId, sort));
    }

    // 0010
    @PostMapping("/newpromopost")
    public ResponseEntity<?> createPromoPost(@RequestBody CreatePromoPostDTO createPromoPostDTO) {
        postService.createPost(createPromoPostDTO);
        return ResponseEntity.ok().build();
    }

    // 0011
    @PostMapping("/{sellerId}/countPromo")
    public ResponseEntity<PostPromoCountDTO> countPromoPost(@PathVariable Long sellerId) {
        return ResponseEntity.ok(postService.countPromoPost(sellerId));
    }

    // 0012
    @GetMapping("/{sellerId}/list")
    public ResponseEntity<PostPromoListDTO> postPromoListFromSeller(@PathVariable Long sellerId) {
        return ResponseEntity.ok(postService.postPromoListFromSeller(sellerId));
    }
}
