package com.raul.demoopenapi.users.service;

import com.raul.demoopenapi.common.ApiPager;
import com.raul.demoopenapi.exceptions.NotFoundException;
import com.raul.demoopenapi.users.persistence.User;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;


@Tag(name = "User", description = "REST API for User information.")
public interface IUserService {

    ApiPager<User> getAllUsers(PageRequest pageable);

    User getUserById(Long id) throws NotFoundException;

    User createUser(User user);

    User updateUser(User updatedUser, Long id);

    void deleteUser(Long id);
}
