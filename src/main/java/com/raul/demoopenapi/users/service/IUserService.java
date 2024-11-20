package com.raul.demoopenapi.users.service;

import com.raul.demoopenapi.exceptions.NotFoundException;
import com.raul.demoopenapi.users.persistence.User;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "User", description = "REST API for User information.")
public interface IUserService {
    List<User> getAllUsers();

    User getUserById(Long id) throws NotFoundException;

    User createUser(User user);

    User updateUser(User updatedUser);

    void deleteUser(Long id);
}
