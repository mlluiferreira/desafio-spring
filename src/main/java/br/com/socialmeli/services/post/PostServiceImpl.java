package br.com.socialmeli.services.post;

import br.com.socialmeli.dtos.SortParam;
import br.com.socialmeli.dtos.post.CreateRegularPostDTO;
import br.com.socialmeli.dtos.post.PostFromSellerByClientDTO;
import br.com.socialmeli.dtos.post.PostPromoCountDTO;
import br.com.socialmeli.dtos.post.PostPromoDTO;
import br.com.socialmeli.dtos.post.PostPromoListDTO;
import br.com.socialmeli.dtos.post.PostRegularDTO;
import br.com.socialmeli.dtos.product.ProductDTO;
import br.com.socialmeli.dtos.user.seller.SellerDTO;
import br.com.socialmeli.entities.post.Post;
import br.com.socialmeli.entities.product.Product;
import br.com.socialmeli.entities.users.Seller;
import br.com.socialmeli.exceptions.product.ProductNotFoundException;
import br.com.socialmeli.exceptions.user.ClientNotFoundException;
import br.com.socialmeli.repositories.post.PostRepository;
import br.com.socialmeli.services.Product.ProductService;
import br.com.socialmeli.services.SortService;
import br.com.socialmeli.services.user.UserService;
import org.apache.commons.lang.StringUtils;
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
    public PostPromoListDTO postPromoListFromSeller(Long sellerId) {
        SellerDTO sellerDTO = userService.findSellerById(sellerId);
        List<Post> posts = postRepository.findBySellerIdAndHasPromoTrue(sellerId);
        PostPromoListDTO postPromoListDTO = new PostPromoListDTO();
        postPromoListDTO.setUserId(sellerId);
        postPromoListDTO.setUserName(sellerDTO.getName());
        postPromoListDTO.setPosts(posts.stream().map(this::mapperToPostPromoDTO).collect(Collectors.toSet()));
        return postPromoListDTO;
    }

    @Override
    public PostPromoCountDTO countPromoPost(Long sellerId) {
        SellerDTO seller = userService.findSellerById(sellerId);
        Long numberOfPromoPost = postRepository.countBySellerIdAndHasPromoTrue(sellerId);
        return new PostPromoCountDTO(sellerId, seller.getName(), numberOfPromoPost);
    }

    @Override
    public PostRegularDTO createPost(CreateRegularPostDTO createPostDTO) {
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

        return mapperToPostRegularDTO(post);
    }

    @Override
    public PostFromSellerByClientDTO postListOfSellerThaClientFollowBetweenLastTwoWeeksAndOrderedByDateDesc(Long clientId) {
        return postListOfSellerThaClientFollowBetweenLastTwoWeeksAndOrderedByDateDesc(clientId, new SortParam("date_desc"));
    }

    @Override
    public PostFromSellerByClientDTO postListOfSellerThaClientFollowBetweenLastTwoWeeksAndOrderedByDateDesc(Long clientId, SortParam sort) {
        if(userService.findClientById(clientId) == null) throw new ClientNotFoundException(null);

        if(sort == null || StringUtils.isBlank(sort.getOrder())) sort = new SortParam("date_desc");

        LocalDate today = LocalDate.now();
        LocalDate twoWeeksAgo = today.minusWeeks(2);

        List<Long> sellersFollowedByClient = userService.sellersIdFollowedByClient(clientId);
        List<PostRegularDTO> posts = postRepository.findBySellerIdInAndDateBetween(
                sellersFollowedByClient,
                twoWeeksAgo,
                today, SortService.build(sort)
        ).stream().map(this::mapperToPostRegularDTO).collect(Collectors.toList());

        PostFromSellerByClientDTO postFromSellerByClientDTO = new PostFromSellerByClientDTO();
        postFromSellerByClientDTO.setPosts(posts);
        postFromSellerByClientDTO.setUserId(clientId);

        return postFromSellerByClientDTO;
    }

    private PostRegularDTO mapperToPostRegularDTO(Post post) {
        PostRegularDTO postRegularDTO = new PostRegularDTO();
        BeanUtils.copyProperties(post, postRegularDTO);
        postRegularDTO.setUserId(post.getSeller().getId());
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(post.getProduct(), productDTO);
        postRegularDTO.setProduct(productDTO);
        return postRegularDTO;
    }

    private PostPromoDTO mapperToPostPromoDTO(Post post) {
        PostPromoDTO postPromoDTO = new PostPromoDTO();
        BeanUtils.copyProperties(post, postPromoDTO);
        postPromoDTO.setUserId(post.getSeller().getId());
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(post.getProduct(), productDTO);
        postPromoDTO.setProduct(productDTO);
        return postPromoDTO;
    }
}
