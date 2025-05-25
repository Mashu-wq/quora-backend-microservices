package com.zeroo8.quora.dto.likeDTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LikeResponse {
    private UUID id;
    private UUID userId;
    private String targetId;
    private String targetType;
    private String message;
}