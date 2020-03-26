package com.vendor.services;

import com.vendor.dtos.CreateUserRequest;
import com.vendor.dtos.UpdateUserRequest;
import com.vendor.exceptions.UserDoesntExists;
import com.vendor.models.User;
import com.vendor.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {
    private UserRepository userRepository;


    public void createUser(CreateUserRequest createUserRequest) {
        User user = new User();
        user.setBucketName(createUserRequest.getBucketName());
        user.setVendorName(createUserRequest.getName());
        user.setRole(createUserRequest.getRole());
        userRepository.save(user);
    }

    public void updateUser(UpdateUserRequest updateUserRequest) throws UserDoesntExists {
        User user = userRepository.findById(updateUserRequest.getId()).orElseThrow(UserDoesntExists::new);
        updateUserFields(updateUserRequest, user);
        userRepository.save(user);
    }

    private void updateUserFields(UpdateUserRequest updateUserRequest, User user) {
        if (updateUserRequest.getName() != null) {
            user.setVendorName(updateUserRequest.getName());
        }
        if (updateUserRequest.getBucketName() != null) {
            user.setBucketName(updateUserRequest.getBucketName());
        }
    }

    public void deleteUser(long userId) {
        userRepository.deleteById(userId);
    }
}
