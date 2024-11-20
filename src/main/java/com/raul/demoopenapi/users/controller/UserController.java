package com.raul.demoopenapi.users.controller;

import com.raul.demoopenapi.exceptions.NotFoundException;
import com.raul.demoopenapi.users.models.CreateUserBody;
import com.raul.demoopenapi.users.persistence.User;
import com.raul.demoopenapi.users.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController implements IUserController {

    private final IUserService service;

    public UserController(@Autowired IUserService service) {
        this.service = service;
    }

    @Override
    public List<User> getUsers() {
        return service.getAllUsers();
    }

    @Override
    public User getUser(@PathVariable Long id) throws NotFoundException {
        return service.getUserById(id);
    }

    @Override
    public User create(@RequestBody CreateUserBody body) {
        return service.createUser(new User(body));
    }

    @Override
    public void delete(@PathVariable Long id){
        service.deleteUser(id);
    }
}
