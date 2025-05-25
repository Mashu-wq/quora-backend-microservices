package com.zeroo8.quora.adapter;

import com.zeroo8.quora.dto.userDTO.CreateUserRequest;
import com.zeroo8.quora.dto.userDTO.UpdateUserRequest;
import com.zeroo8.quora.dto.userDTO.UserResponse;
import com.zeroo8.quora.models.User;
import org.springframework.stereotype.Component;

@Component
public class UserAdapter {
    public UserResponse toResponse(User user) {
        return UserResponse.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .bio(user.getBio())
                .build();
    }

    public User toEntity(CreateUserRequest request) {
        return User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .build();
    }

    public void updateEntity(User user, UpdateUserRequest request) {
        if (request.getUsername() != null) user.setUsername(request.getUsername());
        if (request.getEmail() != null) user.setEmail(request.getEmail());
        if (request.getBio() != null) user.setBio(request.getBio());
    }
}
