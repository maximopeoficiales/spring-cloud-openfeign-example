package com.baeldung.cloud.openfeign.service;

import com.baeldung.cloud.openfeign.model.User;

import java.util.List;

public interface UserJSONPlaceHolderService {

    List<User> getUsers();

    User getUserById(Long id);
}
