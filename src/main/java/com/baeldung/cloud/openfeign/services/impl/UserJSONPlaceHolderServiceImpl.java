package com.baeldung.cloud.openfeign.services.impl;

import com.baeldung.cloud.openfeign.clients.UserJsonPlaceHolderClient;
import com.baeldung.cloud.openfeign.models.User;
import com.baeldung.cloud.openfeign.services.UserJSONPlaceHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserJSONPlaceHolderServiceImpl implements UserJSONPlaceHolderService {
    @Autowired
    private UserJsonPlaceHolderClient client;

    @Override
    public List<User> getUsers() {
        return client.getUsers();
    }

    @Override
    public User getUserById(Long id) {
        return client.getUserById(id);
    }
}
