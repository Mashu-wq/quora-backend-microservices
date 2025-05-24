package com.zeroo8.quora.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Topic extends BaseModel {

    @Column(nullable = false, unique = true)
    private String name;
}
