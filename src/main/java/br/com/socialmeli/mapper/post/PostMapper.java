package br.com.socialmeli.mapper.post;

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
import org.springframework.beans.BeanUtils;

import java.util.List;
import java.util.stream.Collectors;

public class PostMapper {

    public static PostRegularDTO buildPostRegular(Post post) {
        PostRegularDTO postRegularDTO = new PostRegularDTO();
        BeanUtils.copyProperties(post, postRegularDTO);
        postRegularDTO.setUserId(post.getSeller().getId());
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(post.getProduct(), productDTO);
        postRegularDTO.setProduct(productDTO);
        return postRegularDTO;
    }

    public static PostPromoDTO buildPromoPost(Post post) {
        PostPromoDTO postPromoDTO = new PostPromoDTO();
        BeanUtils.copyProperties(post, postPromoDTO);
        postPromoDTO.setUserId(post.getSeller().getId());
        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(post.getProduct(), productDTO);
        postPromoDTO.setProduct(productDTO);
        return postPromoDTO;
    }

    public static PostPromoListDTO buildPostPromoList(SellerDTO seller, List<Post> posts) {
        PostPromoListDTO postPromoListDTO = new PostPromoListDTO();
        postPromoListDTO.setUserId(seller.getId());
        postPromoListDTO.setUserName(seller.getName());
        postPromoListDTO.setPosts(posts.stream().map(PostMapper::buildPromoPost).collect(Collectors.toSet()));
        return postPromoListDTO;
    }

    public static List<PostRegularDTO> buildListOfPostRegular(List<Post> posts) {
        return posts.stream().map(PostMapper::buildPostRegular).collect(Collectors.toList());
    }

    public static PostFromSellerByClientDTO buildPostFromSellerByClientDTO(Long clientId, List<Post> posts) {
        PostFromSellerByClientDTO postFromSellerByClientDTO = new PostFromSellerByClientDTO();
        postFromSellerByClientDTO.setPosts(buildListOfPostRegular(posts));
        postFromSellerByClientDTO.setUserId(clientId);
        return postFromSellerByClientDTO;
    }

    public static Post buildRegularPost(ProductDTO productDTO, SellerDTO sellerDTO, CreateRegularPostDTO createRegularPostDTO) {
        Product product = new Product();
        BeanUtils.copyProperties(productDTO, product);

        Seller seller = new Seller();
        BeanUtils.copyProperties(sellerDTO, seller);

        Post post = new Post();
        BeanUtils.copyProperties(createRegularPostDTO, post);
        post.setProduct(product);
        post.setSeller(seller);

        return post;
    }

    public static PostPromoCountDTO buildPostPromoCount(SellerDTO sellerDTO, Long numberOfPromoPosts) {
        return new PostPromoCountDTO(sellerDTO.getId(), sellerDTO.getName(), numberOfPromoPosts);
    }
}
