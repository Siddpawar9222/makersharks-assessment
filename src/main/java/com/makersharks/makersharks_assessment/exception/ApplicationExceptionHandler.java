package com.makersharks.makersharks_assessment.exception;


import com.makersharks.makersharks_assessment.model.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
@ControllerAdvice
public class ApplicationExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<Response> handleNoHandlerFoundException(NoHandlerFoundException exception) {
        Response response = new Response();
        response.setMessage("Resource not found : " + exception.getMessage());
        response.setResultCode(HttpStatus.NOT_FOUND.value());
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }

//    @ResponseStatus(HttpStatus.BAD_REQUEST)
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public Map<String, String> handleInvalidArgument(MethodArgumentNotValidException exception) {
//        Map<String, String> errorMap = new HashMap<>();
//        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
//            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
//        });
//        return errorMap;
//    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response> handleInvalidArgument(MethodArgumentNotValidException exception) {
        Response response = new Response();
        Map<String, String> errorMap = new HashMap<>();
        exception.getBindingResult().getFieldErrors().forEach(fieldError -> {
            errorMap.put(fieldError.getField(), fieldError.getDefaultMessage());
        });

        response.setMessage("Invalid body : " + errorMap.values());
        response.setResultCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<Response> handleInvalidArgument(MissingServletRequestParameterException exception) {
        Response response = new Response();

        response.setMessage(exception.getMessage());
        response.setResultCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Response> handleBadRequestException(BadRequestException exception) {
        Response response = new Response();
        response.setMessage(exception.getMessage());
        response.setResultCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceUnavailableException.class)
    public ResponseEntity<Response> handleResourceUnavailableException(ResourceUnavailableException exception) {
        Response response = new Response();
        response.setMessage(exception.getMessage());
        response.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UsernameAlreadyExistException.class)
    public ResponseEntity<Response> handleUsernameAlreadyExistException(UsernameAlreadyExistException exception) {
        Response response = new Response();
        response.setMessage(exception.getMessage());
        response.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(LoginException.class)
    public ResponseEntity<Response> LoginException(LoginException exception) {
        Response response = new Response();
        response.setMessage(exception.getMessage());
        response.setResultCode(HttpStatus.UNAUTHORIZED.value());
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }


    @ExceptionHandler(NumberFormatException.class)
    public ResponseEntity<Response> handleInternalServerException(NumberFormatException e) {
        Response response = new Response();
        response.setMessage(e.getMessage());
        response.setResultCode(HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }


    @ExceptionHandler(CaughtException.class)
    public ResponseEntity<Response> handleSubjectCreationException(CaughtException e) {
        Response response = new Response();
        response.setMessage(e.getMessage());
        response.setResultCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
