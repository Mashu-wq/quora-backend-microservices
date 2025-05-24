package com.zeroo8.quora.service;

import com.zeroo8.quora.adapter.UserAdapter;
import com.zeroo8.quora.dto.CreateUserRequest;
import com.zeroo8.quora.dto.UpdateUserRequest;
import com.zeroo8.quora.dto.UserResponse;
import com.zeroo8.quora.exception.CustomException;
import com.zeroo8.quora.models.User;
import com.zeroo8.quora.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserAdapter userAdapter;

    public UserResponse createUser(CreateUserRequest request) {
        User user = userAdapter.toEntity(request);
        return userAdapter.toResponse(userRepository.save(user));
    }

    public UserResponse getUserById(UUID id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));
        return userAdapter.toResponse(user);
    }

    @Transactional
    public UserResponse updateUser(UUID id, UpdateUserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));
        userAdapter.updateEntity(user, request);
        return userAdapter.toResponse(user);
    }
}
