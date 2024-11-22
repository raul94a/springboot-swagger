package com.raul.demoopenapi.users.controller;

import com.raul.demoopenapi.common.ApiPager;
import com.raul.demoopenapi.exceptions.NotFoundException;
import com.raul.demoopenapi.users.models.CreateUserBody;
import com.raul.demoopenapi.users.persistence.User;
import com.raul.demoopenapi.users.service.IUserService;
import jakarta.annotation.Nullable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;


@RestController()
@RequestMapping(value = "/users", produces = MediaType.APPLICATION_JSON_VALUE)
public class UserController implements IUserController {

    private final IUserService service;

    public UserController(@Autowired IUserService service) {
        this.service = service;
    }

    @Override
    public ApiPager<User> getUsers(@Nullable Integer page,@Nullable Integer size) {
        if(page == null){
            page = 0;
        }
        if(size == null){
            size = 25;
        }
        PageRequest request = PageRequest.of(page ,size);
        return service.getAllUsers(request);
    }

    @Override
    public User getUser(Long id) throws NotFoundException {
        return service.getUserById(id);
    }

    @Override
    public User create(CreateUserBody body) {
        return service.createUser(new User(body));
    }

    @Override
    public User update(Long id, User user) {
        return service.updateUser(user,id);
    }

    @Override
    public void delete(Long id){
        service.deleteUser(id);
    }
}
