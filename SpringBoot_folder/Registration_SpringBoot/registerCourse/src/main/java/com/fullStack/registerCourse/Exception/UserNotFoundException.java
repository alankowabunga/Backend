package com.fullStack.registerCourse.Exception;

import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin(origins = "*")
public class UserNotFoundException extends RuntimeException{

    //    Constructor
    public UserNotFoundException(Integer id) {

        super("User Not Found with ID : "+ id);
    }
}
