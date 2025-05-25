package com.zeroo8.quora.dto.questionDTO;
import lombok.*;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionResponse {
    private UUID id;
    private String title;
    private String body;
    private List<String> topicTags;
    private UUID userId;
    private String username;
    private LocalDateTime createdAt;
}
