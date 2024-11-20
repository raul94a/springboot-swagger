package com.raul.demoopenapi.users.service;

import com.raul.demoopenapi.exceptions.NotFoundException;
import com.raul.demoopenapi.users.persistence.User;
import com.raul.demoopenapi.users.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Page<User> getAllUsers(Pageable pageable) {

       return userRepository.findAll(pageable);

    }
    @Override
    public User getUserById(Long id) throws NotFoundException {
        var optional = userRepository.findById(id);
        if(optional.isEmpty()){
            throw new NotFoundException();
        }
        return optional.get();
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }
    @Override
    public User updateUser(User updatedUser) {
        return userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}