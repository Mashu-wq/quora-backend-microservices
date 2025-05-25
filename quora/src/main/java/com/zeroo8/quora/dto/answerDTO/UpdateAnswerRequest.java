package com.zeroo8.quora.dto.answerDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UpdateAnswerRequest {
    @NotBlank
    private String text;
}