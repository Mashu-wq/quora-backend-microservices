package com.zeroo8.quora.service;

import com.zeroo8.quora.adapter.UserAdapter;
import com.zeroo8.quora.dto.userDTO.CreateUserRequest;
import com.zeroo8.quora.dto.userDTO.UpdateUserRequest;
import com.zeroo8.quora.dto.userDTO.UserResponse;
import com.zeroo8.quora.exception.CustomException;
import com.zeroo8.quora.exception.EmailAlreadyExistsException;
import com.zeroo8.quora.models.User;
import com.zeroo8.quora.repositories.UserRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final UserAdapter userAdapter;

//    public UserResponse createUser(CreateUserRequest request) {
//        User user = userAdapter.toEntity(request);
//        return userAdapter.toResponse(userRepository.save(user));
//    }
public UserResponse createUser(CreateUserRequest request) {
    if (userRepository.existsByEmail(request.getEmail())) {
        throw new EmailAlreadyExistsException("Email already exists: " + request.getEmail());
    }
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

    public List<UserResponse> getAllUsers() {
        return userRepository.findAll().stream()
                .map(userAdapter::toResponse)
                .toList();
    }
}
