package com.cleyton.manage_cars.repository;

import com.cleyton.manage_cars.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}
