package com.raul.demoopenapi.users.validators;

import com.raul.demoopenapi.users.models.CreateUserBody;
import com.raul.demoopenapi.users.persistence.User;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Objects;


@Configuration
public class UserValidatorImpl implements UserValidator{
    @Override
    public void updateUserValidator(User user, Long id) throws HttpClientErrorException.BadRequest {
        if (!Objects.equals(user.getId(), id)){
            throw HttpClientErrorException.create(HttpStatus.BAD_REQUEST, "Bad Request",null,null,null);
        }
    }

    @Override
    public void createUserValidator(User body) throws HttpClientErrorException.BadRequest {
        // valid name?
        // valid lastName?
    }
}
