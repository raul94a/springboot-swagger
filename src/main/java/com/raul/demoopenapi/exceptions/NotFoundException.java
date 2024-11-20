package com.raul.demoopenapi.exceptions;

public class NotFoundException extends BaseApiException{

    @Override
    public int getStatusCode() {
        return 404;
    }
}
