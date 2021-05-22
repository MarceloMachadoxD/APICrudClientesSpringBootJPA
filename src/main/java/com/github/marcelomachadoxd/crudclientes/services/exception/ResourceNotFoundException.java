package com.github.marcelomachadoxd.crudclientes.services.exception;

public class ResourceNotFoundException extends RuntimeException{

    public ResourceNotFoundException(String msg) {
        super(msg);
    }
}
