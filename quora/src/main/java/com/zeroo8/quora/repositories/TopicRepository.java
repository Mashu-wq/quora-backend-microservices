package com.zeroo8.quora.repositories;

import com.zeroo8.quora.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.UUID;

public interface TopicRepository extends JpaRepository<Topic, UUID> {
    boolean existsByName(String name);
}