package com.vendor.services;

import com.vendor.exceptions.UserDoesntExists;
import com.vendor.dtos.CreateUserRequest;
import com.vendor.dtos.UpdateUserRequest;
import com.vendor.models.User;
import com.vendor.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private UserRepository userRepository;


    public void createUser(CreateUserRequest createUserRequest) {
        userRepository.save(new User(createUserRequest.getName(), createUserRequest.getBucketName()));
    }

    public void updateUser(UpdateUserRequest updateUserRequest) throws UserDoesntExists {
        User user = userRepository.findById(updateUserRequest.getId()).orElseThrow(UserDoesntExists::new);
        updateUserFields(updateUserRequest, user);
        userRepository.save(user);
    }

    private void updateUserFields(UpdateUserRequest updateUserRequest, User user) {
        if (updateUserRequest.getName() != null) {
            user.setName(updateUserRequest.getName());
        }
        if (updateUserRequest.getBucketName() != null) {
            user.setBucketName(updateUserRequest.getBucketName());
        }
    }
}
