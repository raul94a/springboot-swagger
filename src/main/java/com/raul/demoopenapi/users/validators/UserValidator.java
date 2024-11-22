package com.raul.demoopenapi.users.validators;

import com.raul.demoopenapi.users.persistence.User;
import org.springframework.web.client.HttpClientErrorException;

public interface UserValidator {

    void updateUserValidator(User user, Long id) throws HttpClientErrorException.BadRequest;
    void createUserValidator(User user) throws HttpClientErrorException.BadRequest;

}
