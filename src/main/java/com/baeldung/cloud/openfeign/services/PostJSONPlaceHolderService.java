package com.baeldung.cloud.openfeign.services;

import com.baeldung.cloud.openfeign.models.Post;

import java.util.List;

public interface PostJSONPlaceHolderService {

    List<Post> getPosts();

    Post getPostById(Long id);
}
