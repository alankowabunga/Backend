package com.fullStack.registerCourse.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "*")
@ControllerAdvice
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFoundAdvice {

    @ExceptionHandler(UserNotFoundException.class)
    public Map<String,String> exceptionAdvice(UserNotFoundException exception) {

        Map<String,String> errorMap = new HashMap<>();
        errorMap.put("Error Message : ", exception.getMessage());

        return errorMap;
    }
}
