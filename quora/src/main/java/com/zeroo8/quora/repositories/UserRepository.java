package com.zeroo8.quora.repositories;

import com.zeroo8.quora.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
}
