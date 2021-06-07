package br.com.socialmeli.services.post;

import br.com.socialmeli.dtos.SortParam;
import br.com.socialmeli.dtos.post.CreateRegularPostDTO;
import br.com.socialmeli.dtos.post.PostFromSellerByClientDTO;
import br.com.socialmeli.dtos.post.PostPromoCountDTO;
import br.com.socialmeli.dtos.post.PostPromoListDTO;
import br.com.socialmeli.dtos.post.PostRegularDTO;
import br.com.socialmeli.dtos.product.ProductDTO;
import br.com.socialmeli.dtos.user.seller.SellerDTO;
import br.com.socialmeli.entities.post.Post;
import br.com.socialmeli.exceptions.product.ProductNotFoundException;
import br.com.socialmeli.exceptions.user.ClientNotFoundException;
import br.com.socialmeli.mapper.post.PostMapper;
import br.com.socialmeli.repositories.post.PostRepository;
import br.com.socialmeli.services.Product.ProductService;
import br.com.socialmeli.services.SortService;
import br.com.socialmeli.services.user.UserService;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

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
        return PostMapper.buildPostPromoList(sellerDTO, posts);
    }

    @Override
    public PostPromoCountDTO countPromoPost(Long sellerId) {
        SellerDTO sellerDTO = userService.findSellerById(sellerId);
        Long numberOfPromoPosts = postRepository.countBySellerIdAndHasPromoTrue(sellerId);
        return PostMapper.buildPostPromoCount(sellerDTO, numberOfPromoPosts);
    }

    @Override
    public PostRegularDTO createPost(CreateRegularPostDTO createPostDTO) {
        Optional<ProductDTO> productOp = productService.findById(createPostDTO.getProductId());
        if(productOp.isEmpty()) throw new ProductNotFoundException(createPostDTO.getProductId());

        SellerDTO sellerDTO = userService.findSellerById(createPostDTO.getUserId());

        Post post = PostMapper.buildRegularPost(productOp.get(), sellerDTO, createPostDTO);
        post = postRepository.save(post);
        return PostMapper.buildPostRegular(post);
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
        List<Post> posts = postRepository.findBySellerIdInAndDateBetween(sellersFollowedByClient, twoWeeksAgo, today, SortService.build(sort));

        return PostMapper.buildPostFromSellerByClientDTO(clientId, posts);
    }
}
