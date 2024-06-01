package com.personal.userManagement_app.utils.errors;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserNotFoundException extends RuntimeException {
    private final long id;
    //Error that occurs when entity cannot be found in the database

    public UserNotFoundException(long id) {
        super("User with ID " + id + " not found");
        this.id = id;
    }

}
