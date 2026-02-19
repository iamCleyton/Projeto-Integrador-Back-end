package com.cleyton.manage_cars.controller;

import com.cleyton.manage_cars.dto.request.LoginDto;
import com.cleyton.manage_cars.dto.response.LoginResponseDto;
import com.cleyton.manage_cars.utils.jwt.JwtUtils;
// Importe a sua entidade User e seu UserRepository
import com.cleyton.manage_cars.entity.User;
import com.cleyton.manage_cars.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authenticationManager;
    private final JwtUtils jwtUtils;
    private final UserRepository userRepository; // Injetando o repositório

    @PostMapping("/login")
    public ResponseEntity<Object> login(@RequestBody LoginDto loginDto) {
        try {
            authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(loginDto.email(), loginDto.password())
            );

            String token = jwtUtils.generateToken(loginDto.email());

            // 1. Busca o usuário no banco pelo email para pegar o nome
            // (Ajuste "findByEmail" para o nome do método que você tem no seu repositório)
            User user = userRepository.findByEmail(loginDto.email()).orElseThrow();

            // 2. Agora devolvemos o token, o email e o NOME real!
            LoginResponseDto responseDto = new LoginResponseDto(token, user.getEmail(), user.getName());

            return ResponseEntity.ok(responseDto);

        } catch (BadCredentialsException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(Map.of("message", "Erro: Incorrect Email or password."));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(Map.of("message", "Internal server error."));
        }
    }
}