package com.example.course_isystem.controller;

import com.example.course_isystem.dto.AuthDto;
import com.example.course_isystem.dto.RegisterDto;
import com.example.course_isystem.dto.UsersDto;
import com.example.course_isystem.model.AuthData;
import com.example.course_isystem.service.AuthService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@AllArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {
    private AuthService authService;

    @PostMapping("/register")
    public ResponseEntity<?> register (@RequestBody @Valid RegisterDto dto){
        AuthData result = authService.register(dto);
        return ResponseEntity.ok(result);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody @Valid AuthDto dto){
        AuthDto result = authService.login(dto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/verification/{token}")
    public ResponseEntity<?> verification(@PathVariable("token") String token){
        UsersDto result = authService.verification(token);
        return ResponseEntity.ok(result);
    }
}
