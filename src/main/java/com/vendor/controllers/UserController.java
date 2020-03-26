package com.vendor.controllers;

import com.vendor.dtos.CreateUserRequest;
import com.vendor.dtos.UpdateUserRequest;
import com.vendor.exceptions.UserDoesntExists;
import com.vendor.services.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController("/user")
@AllArgsConstructor
public class UserController {
    private UserService userService;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public void createUser(@RequestBody CreateUserRequest createUserRequest) {
        userService.createUser(createUserRequest);
    }

    @PutMapping
    @ResponseStatus(code = HttpStatus.OK)
    public void updateUser(@RequestBody UpdateUserRequest updateUserRequest) {
        try {
            userService.updateUser(updateUserRequest);
        } catch (UserDoesntExists userDoesntExists) {
            userDoesntExists.printStackTrace();
        }
    }

    @DeleteMapping
    public void deleteUser(@PathVariable("userId") String userId) {
        userService.deleteUser(Long.parseLong(userId));
    }
}
