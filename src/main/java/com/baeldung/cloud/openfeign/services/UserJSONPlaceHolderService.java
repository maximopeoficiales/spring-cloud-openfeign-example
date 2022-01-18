package com.baeldung.cloud.openfeign.services;

import com.baeldung.cloud.openfeign.models.User;

import java.util.List;

public interface UserJSONPlaceHolderService {

    List<User> getUsers();

    User getUserById(Long id);
}
