package com.cleyton.manage_cars.service;

import com.cleyton.manage_cars.entity.User;
import com.cleyton.manage_cars.exception.EmailUniqueViolationException;
import com.cleyton.manage_cars.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Service
public class UserService {

   //salva criptografado no banco
    private final UserRepository userRepository;


    private final PasswordEncoder passwordEncoder;

    @Transactional
    public User save(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        try {
            return userRepository.save(user);
        } catch (DataIntegrityViolationException ex) {
            throw new EmailUniqueViolationException("Email already exist");
        }
    }
}
