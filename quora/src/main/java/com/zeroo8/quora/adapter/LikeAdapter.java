package com.zeroo8.quora.adapter;

import com.zeroo8.quora.dto.likeDTO.LikeResponse;
import com.zeroo8.quora.models.Like;
import org.springframework.stereotype.Component;

@Component
public class LikeAdapter {
    public LikeResponse toResponse(Like like) {
        return LikeResponse.builder()
                .id(like.getId())
                .userId(like.getUser().getId())
                .targetId(like.getTargetId())
                .targetType(like.getTargetType())
                .message("Liked successfully")
                .build();
    }
}