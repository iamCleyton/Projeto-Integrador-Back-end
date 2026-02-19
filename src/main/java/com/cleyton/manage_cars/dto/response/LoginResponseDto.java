package com.cleyton.manage_cars.dto.response;

// O Spring vai converter isso automaticamente para: {"token": "...", "email": "..."}
public record LoginResponseDto(String token, String email, String name) {
}