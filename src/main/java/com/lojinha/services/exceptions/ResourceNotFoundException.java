package com.lojinha.services.exceptions;

public class ResourceNotFoundException extends RuntimeException {

    private static long serialVersionUID = 1L;

    public ResourceNotFoundException(Object id) {
        super("Resource not found. Id " + id);
    }

}
