package com.zeroo8.quora.dto.topicDTO;

import lombok.*;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class TopicResponse {
    private UUID id;
    private String name;
}
