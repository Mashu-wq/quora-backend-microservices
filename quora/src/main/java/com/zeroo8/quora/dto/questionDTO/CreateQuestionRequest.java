package com.zeroo8.quora.dto.questionDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateQuestionRequest {
    @NotNull
    private UUID userId;

    @NotBlank
    private String title;

    @NotBlank
    private String body;

    private List<String> topicTags;
}
