package com.zeroo8.quora.dto.answerDTO;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateAnswerRequest {
    @NotNull
    private UUID userId;

    @NotBlank
    private String text;
}
