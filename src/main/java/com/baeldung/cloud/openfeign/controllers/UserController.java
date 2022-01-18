package com.baeldung.cloud.openfeign.controllers;


import com.baeldung.cloud.openfeign.model.Post;
import com.baeldung.cloud.openfeign.model.User;
import com.baeldung.cloud.openfeign.service.UserJSONPlaceHolderService;
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
@RequestMapping("/public/user")
public class UserController {
    @Autowired
    private UserJSONPlaceHolderService client;

    @GetMapping("/all")
    @ApiOperation("Get all user")
    @ApiResponse(code = 200, message = "OK")
    public ResponseEntity<List<User>> getAll() {
        return new ResponseEntity<>(client.getUsers(), HttpStatus.OK);
    }

    @GetMapping("/findById/{id}")
    @ApiOperation("Search a user with a ID")
    @ApiResponses({@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "User not found")})
    public ResponseEntity<User> getById(
            @ApiParam(value = "The id of the user", required = true, example = "5")
            @PathVariable("id") Long id) {
        return new ResponseEntity<>(client.getUserById(id), HttpStatus.NOT_FOUND);
    }
}
