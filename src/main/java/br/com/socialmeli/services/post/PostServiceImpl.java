package br.com.socialmeli.services.post;

import br.com.socialmeli.dtos.post.CreatePostDTO;
import br.com.socialmeli.dtos.post.PostDTO;
import br.com.socialmeli.dtos.post.PostFromSellerByClientDTO;
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

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private final PostRepository postRepository;

    private final ProductService productService;

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

    @Override
    public PostFromSellerByClientDTO postListOfSellerThaClientFollowBetweenLastTwoWeeksAndOrderedByDateDesc(Long clientId) {
        LocalDate today = LocalDate.now();
        LocalDate twoWeeksAgo = today.minusWeeks(2);
        List<Long> sellersFollowedByClient = userService.sellersIdFollowedByClient(clientId);
        List<PostDTO> posts = postRepository.findBySellerIdInAndCreationDateBetweenOrderByCreationDate(
                sellersFollowedByClient,
                twoWeeksAgo,
                today
        ).stream().map(this::mapperToPostDTO).collect(Collectors.toList());
        PostFromSellerByClientDTO postFromSellerByClientDTO = new PostFromSellerByClientDTO();
        postFromSellerByClientDTO.setPosts(posts);
        postFromSellerByClientDTO.setUserId(clientId);
        return postFromSellerByClientDTO;
    }

    private PostDTO mapperToPostDTO(Post post, ProductDTO productDTO) {
        PostDTO postDTO = new PostDTO();
        BeanUtils.copyProperties(post, postDTO);
        postDTO.setUserId(post.getSeller().getId());
        postDTO.setProduct(productDTO);
        return postDTO;
    }

    private PostDTO mapperToPostDTO(Post post) {
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(post.getProduct(), productDTO);
        return mapperToPostDTO(post, productDTO);
    }
}
