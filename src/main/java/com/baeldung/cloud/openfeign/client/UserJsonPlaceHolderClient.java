package com.baeldung.cloud.openfeign.client;

import com.baeldung.cloud.openfeign.exception.config.FeignConfig;
import com.baeldung.cloud.openfeign.model.Post;
import com.baeldung.cloud.openfeign.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "user-client", url="https://jsonplaceholder.typicode.com",
		configuration = FeignConfig.class)
public interface UserJsonPlaceHolderClient {

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	List<User> getUsers();

	@RequestMapping(method = RequestMethod.GET, value = "/users/{userId}", produces = "application/json")
	User getUserById(@PathVariable("userId") Long userId);
}