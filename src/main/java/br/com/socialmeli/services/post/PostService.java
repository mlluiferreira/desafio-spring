package br.com.socialmeli.services.post;

import br.com.socialmeli.dtos.SortParam;
import br.com.socialmeli.dtos.post.CreateRegularPostDTO;
import br.com.socialmeli.dtos.post.PostFromSellerByClientDTO;
import br.com.socialmeli.dtos.post.PostPromoCountDTO;
import br.com.socialmeli.dtos.post.PostPromoListDTO;
import br.com.socialmeli.dtos.post.PostRegularDTO;

public interface PostService {
    PostRegularDTO createPost(CreateRegularPostDTO createRegularPostDTO);

    PostFromSellerByClientDTO postListOfSellerThaClientFollowBetweenLastTwoWeeksAndOrderedByDateDesc(Long clientId);

    PostFromSellerByClientDTO postListOfSellerThaClientFollowBetweenLastTwoWeeksAndOrderedByDateDesc(Long clientId, SortParam sort);

    PostPromoCountDTO countPromoPost(Long sellerId);

    PostPromoListDTO postPromoListFromSeller(Long sellerId);
}
