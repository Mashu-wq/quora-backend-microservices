package com.zeroo8.quora.services;

import com.zeroo8.quora.adapter.LikeAdapter;
import com.zeroo8.quora.dto.likeDTO.LikeRequest;
import com.zeroo8.quora.dto.likeDTO.LikeResponse;
import com.zeroo8.quora.exception.CustomException;
import com.zeroo8.quora.models.Like;
import com.zeroo8.quora.models.User;
import com.zeroo8.quora.repositories.LikeRepository;
import com.zeroo8.quora.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final LikeAdapter likeAdapter;

    public LikeResponse like(String type, String id, LikeRequest request) {
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new CustomException("User not found", HttpStatus.NOT_FOUND));

        boolean alreadyLiked = likeRepository.findByUserIdAndTargetIdAndTargetType(user.getId(), id, type).isPresent();

        if (alreadyLiked) {
            throw new CustomException("Already liked this " + type, HttpStatus.BAD_REQUEST);
        }

        Like like = Like.builder()
                .user(user)
                .targetId(id)
                .targetType(type)
                .build();

        return likeAdapter.toResponse(likeRepository.save(like));
    }
}