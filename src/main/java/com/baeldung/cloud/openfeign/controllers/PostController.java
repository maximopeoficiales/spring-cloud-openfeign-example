package com.baeldung.cloud.openfeign.controllers;


import com.baeldung.cloud.openfeign.model.Post;
import com.baeldung.cloud.openfeign.service.JSONPlaceHolderService;
import com.baeldung.cloud.openfeign.service.impl.JSONPlaceHolderServiceImpl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/public/post")
public class PostController {
    @Autowired
    private JSONPlaceHolderService client;

    @GetMapping("/all")
    @ApiOperation("Get all posts")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<Post>> getClients() {
        return new ResponseEntity<>(client.getPosts(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    @ApiOperation("Search a post with a ID")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "Post not found")})
    public ResponseEntity<Post> getById(
            @ApiParam(value = "The id of the post", required = true, example = "5")
            @PathVariable("id") Long idPost) {
        return new ResponseEntity<>(client.getPostById(idPost), HttpStatus.NOT_FOUND);
    }
}
