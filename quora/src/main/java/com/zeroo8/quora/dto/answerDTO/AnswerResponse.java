package com.zeroo8.quora.dto.answerDTO;

import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AnswerResponse {
    private UUID id;
    private UUID questionId;
    private String text;
    private UUID userId;
    private String username;
    private LocalDateTime createdAt;
}