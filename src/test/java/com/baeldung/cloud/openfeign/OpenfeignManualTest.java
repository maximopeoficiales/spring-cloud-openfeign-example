package com.baeldung.cloud.openfeign;

import com.baeldung.cloud.openfeign.models.Post;
import com.baeldung.cloud.openfeign.services.PostJSONPlaceHolderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

@RunWith(SpringRunner.class)
@SpringBootTest
class OpenfeignUnitTest {

    @Autowired
    private PostJSONPlaceHolderService postJsonPlaceHolderService;

    @Test
    public void whenSpringContextIsBootstrapped_thenNoExceptions() {
    }

    @Test
    public void whenGetPosts_thenListPostSizeGreaterThanZero() {

        List<Post> posts = postJsonPlaceHolderService.getPosts();

        assertFalse(posts.isEmpty());
    }

    @Test
    public void whenGetPostWithId_thenPostExist() {

        Post post = postJsonPlaceHolderService.getPostById(1L);

        assertNotNull(post);
    }

}
