package com.zeroo8.quora.repositories;

import com.zeroo8.quora.models.Like;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface LikeRepository extends JpaRepository<Like, UUID> {
    Optional<Like> findByUserIdAndTargetIdAndTargetType(UUID userId, String targetId, String targetType);
}