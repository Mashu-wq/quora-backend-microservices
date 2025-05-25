package com.zeroo8.quora.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "likes", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"user_id", "target_id", "target_type"})
})
public class Like extends BaseModel {

    @Column(name = "target_id", nullable = false)
    private String targetId; // UUID as string for generic reference

    @Column(name = "target_type", nullable = false)
    private String targetType; // "questions", "answers", "comments"

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
