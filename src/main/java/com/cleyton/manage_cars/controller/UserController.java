package com.cleyton.manage_cars.controller;

import com.cleyton.manage_cars.dto.mapper.CarMapper;
import com.cleyton.manage_cars.dto.mapper.UserMapper;
import com.cleyton.manage_cars.dto.request.CarCreateDto;
import com.cleyton.manage_cars.dto.request.UserCreateDto;
import com.cleyton.manage_cars.dto.response.CarResponseDto;
import com.cleyton.manage_cars.dto.response.UserResponseDto;
import com.cleyton.manage_cars.entity.Car;
import com.cleyton.manage_cars.entity.User;
import com.cleyton.manage_cars.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("api/user")
public class UserController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<UserResponseDto> create(
             @Valid @RequestBody UserCreateDto dto) {
        User user = UserMapper.toUser(dto);
        User savedUser = userService.save(user);
        UserResponseDto response = UserMapper.toDto(savedUser);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


}
