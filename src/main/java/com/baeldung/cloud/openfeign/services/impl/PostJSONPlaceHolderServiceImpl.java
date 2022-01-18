package com.baeldung.cloud.openfeign.services.impl;

import com.baeldung.cloud.openfeign.clients.PostJSONPlaceHolderClient;
import com.baeldung.cloud.openfeign.models.Post;
import com.baeldung.cloud.openfeign.services.PostJSONPlaceHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostJSONPlaceHolderServiceImpl implements PostJSONPlaceHolderService {

    @Autowired
    private PostJSONPlaceHolderClient postJsonPlaceHolderClient;

    @Override
    public List<Post> getPosts() {
        return postJsonPlaceHolderClient.getPosts();
    }

    @Override
    public Post getPostById(Long id) {
        return postJsonPlaceHolderClient.getPostById(id);
    }
}
