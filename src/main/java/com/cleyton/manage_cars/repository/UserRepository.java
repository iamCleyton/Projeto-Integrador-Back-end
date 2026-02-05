package com.cleyton.manage_cars.repository;

import com.cleyton.manage_cars.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    // O Spring vai gerar a query SQL automaticamente: SELECT * FROM users WHERE email = ?
    Optional<User> findByEmail(String email);
}