package br.com.socialmeli.services.post;

import br.com.socialmeli.dtos.post.CreatePostDTO;
import br.com.socialmeli.dtos.post.PostDTO;
import br.com.socialmeli.dtos.product.ProductDTO;
import br.com.socialmeli.dtos.user.seller.SellerDTO;
import br.com.socialmeli.entities.post.Post;
import br.com.socialmeli.entities.product.Product;
import br.com.socialmeli.entities.users.Seller;
import br.com.socialmeli.exceptions.product.ProductNotFoundException;
import br.com.socialmeli.repositories.post.PostRepository;
import br.com.socialmeli.services.Product.ProductService;
import br.com.socialmeli.services.user.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PostServiceImpl implements PostService {
    private final ProductService productService;

    private final PostRepository postRepository;

    private final UserService userService;

    public PostServiceImpl(ProductService productService, PostRepository postRepository, UserService userService) {
        this.productService = productService;
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Override
    public PostDTO createPost(CreatePostDTO createPostDTO) {
        Optional<ProductDTO> productOp = productService.findById(createPostDTO.getProductId());
        if(productOp.isEmpty()) throw new ProductNotFoundException(createPostDTO.getProductId());
        Product product = new Product();
        BeanUtils.copyProperties(productOp.get(), product);

        SellerDTO sellerDTO = userService.findSellerById(createPostDTO.getUserId());
        Seller seller = new Seller();
        BeanUtils.copyProperties(sellerDTO, seller);

        Post post = new Post();
        BeanUtils.copyProperties(createPostDTO, post);
        post.setProduct(product);
        post.setSeller(seller);

        post = postRepository.save(post);

        return mapperToPostDTO(post, productOp.get());
    }

    private PostDTO mapperToPostDTO(Post post, ProductDTO productDTO) {
        PostDTO postDTO = new PostDTO();
        BeanUtils.copyProperties(post, postDTO);
        postDTO.setUserId(post.getSeller().getId());
        postDTO.setProduct(productDTO);
        return postDTO;
    }
}
