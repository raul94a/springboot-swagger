package com.raul.demoopenapi.users.service;

import com.raul.demoopenapi.exceptions.NotFoundException;
import com.raul.demoopenapi.users.persistence.User;
import com.raul.demoopenapi.users.persistence.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService implements IUserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        List<User> result = new ArrayList<User>();
        userRepository.findAll().forEach(result::add);
        return result;
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