package com.zeroo8.quora.dto.likeDTO;

import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class LikeRequest {
    @NotNull
    private UUID userId;
}