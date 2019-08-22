package com.guppy.auth.repository;

import com.guppy.auth.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * TODO
 *
 * @author Guppy
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
