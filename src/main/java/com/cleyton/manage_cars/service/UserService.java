package com.cleyton.manage_cars.service;

import com.cleyton.manage_cars.entity.Car;
import com.cleyton.manage_cars.entity.User;
import com.cleyton.manage_cars.exception.EmailUniqueViolationException;
import com.cleyton.manage_cars.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    @Transactional
    public User save(User user) {
        try {
            return userRepository.save(user);
        }catch (DataIntegrityViolationException ex) {
            throw new EmailUniqueViolationException(String.format("Email %s already created", user.getEmail()));
        }

    }


}
