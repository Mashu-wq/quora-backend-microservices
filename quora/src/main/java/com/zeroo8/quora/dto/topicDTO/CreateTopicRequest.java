
package com.zeroo8.quora.dto.topicDTO;

import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateTopicRequest {
    @NotBlank
    private String name;
}
