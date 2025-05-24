package com.zeroo8.quora.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Comment extends BaseModel {

    @Lob
    @Column(nullable = false)
    private String text;

    @Column(nullable = false)
    private UUID parentId;  // Can be ID of an Answer or another Comment

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
}
