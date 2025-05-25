package com.zeroo8.quora.dto.commentDTO;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentResponse {
    private UUID id;
    private UUID parentId;
    private String text;
    private UUID userId;
    private String username;
    private LocalDateTime createdAt;
}