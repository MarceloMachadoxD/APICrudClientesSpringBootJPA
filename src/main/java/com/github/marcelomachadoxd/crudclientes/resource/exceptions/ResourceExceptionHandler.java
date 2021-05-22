package com.github.marcelomachadoxd.crudclientes.resource.exceptions;

import com.github.marcelomachadoxd.crudclientes.services.exception.DatabaseException;
import com.github.marcelomachadoxd.crudclientes.services.exception.ResourceNotFoundException;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;

@Configuration
public class ResourceExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> entityNotFound(ResourceNotFoundException e, HttpServletRequest request) {
        StandardError standardError = new StandardError();
        HttpStatus status = HttpStatus.NOT_FOUND;

        standardError.setTimestamp(Instant.now());
        standardError.setStatus(status.value());
        standardError.setError("Resource Not found");
        standardError.setMessage(e.getMessage());
        standardError.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(standardError);
    }

    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<StandardError> database(DatabaseException e, HttpServletRequest request) {
        HttpStatus status = HttpStatus.BAD_REQUEST;
        StandardError standardError = new StandardError();
        standardError.setTimestamp(Instant.now());
        standardError.setStatus(status.value());
        standardError.setError("Database Exception");
        standardError.setMessage(e.getMessage());
        standardError.setPath(request.getRequestURI());

        return ResponseEntity.status(status).body(standardError);
    }
}
