package com.raul.demoopenapi.users.service;

import com.raul.demoopenapi.common.ApiPager;
import com.raul.demoopenapi.common.PageableToApiPagerConverter;
import com.raul.demoopenapi.exceptions.NotFoundException;
import com.raul.demoopenapi.users.persistence.User;
import com.raul.demoopenapi.users.persistence.UserRepository;
import com.raul.demoopenapi.users.validators.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService {


    private final UserRepository userRepository;
    private final UserValidator validator;

    public UserService(@Autowired UserRepository userRepository, @Autowired UserValidator validator) {
        this.userRepository = userRepository;
        this.validator = validator;
    }

    @Override
    public ApiPager<User> getAllUsers(PageRequest pageable) {
        int page = pageable.getPageNumber();
        int size = pageable.getPageSize();
        if (page <= 0) {
            page = 1;
        }
        if (size < 0) {
            size = 10;
        } else {
            int MAX_PAGE_SIZE = 25;
            size = Math.min(size, MAX_PAGE_SIZE);
        }
        pageable = PageRequest.of(page - 1, size);
        Page<User> pager = userRepository.findAll(pageable);

        return PageableToApiPagerConverter.fromPage(pager);

    }

    @Override
    public User getUserById(Long id) throws NotFoundException {
        var optional = userRepository.findById(id);
        if (optional.isEmpty()) {
            throw new NotFoundException();
        }
        return optional.get();
    }

    @Override
    public User createUser(User user) {
        validator.createUserValidator(user);
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User updatedUser,Long id) {
        validator.updateUserValidator(updatedUser, id);
        return userRepository.save(updatedUser);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

}