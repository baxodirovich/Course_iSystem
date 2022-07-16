package com.example.course_isystem.service;

import com.example.course_isystem.configuration.JwtTokenUtil;
import com.example.course_isystem.dto.AuthDto;
import com.example.course_isystem.dto.RegisterDto;
import com.example.course_isystem.dto.UsersDto;
import com.example.course_isystem.exeption.CourseException;
import com.example.course_isystem.model.AuthData;
import com.example.course_isystem.model.UserTypes;
import com.example.course_isystem.model.Users;
import com.example.course_isystem.repository.UserTypesRepository;
import com.example.course_isystem.repository.UsersRepository;
import com.example.course_isystem.util.Roles;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AuthService {
    private MessageService messageService;
    private JwtTokenUtil jwtTokenUtil;
    private UsersRepository usersRepository;
    private UserTypesRepository userTypesRepository;
    private PasswordEncoder passwordEncoder;
    public AuthData register(RegisterDto dto) {
        Optional<Users> optional = usersRepository.
                findByEmailOrPhoneAndDeletedAtIsNull(dto.getEmail(), dto.getPhone());
        if (optional.isPresent()){
            throw new CourseException("User already exist");
        }
        Users users = new Users();
        users.setEmail(dto.getEmail());
        users.setPhone(dto.getPhone());
        users.setPassword(passwordEncoder.encode(dto.getPassword()));
        users.setStatus(false);
        usersRepository.save(users);

        UserTypes userTypes = new UserTypes();
        userTypes.setName(String.valueOf(Roles.ROLE_USER));
        userTypes.setStatus(true);
        userTypesRepository.save(userTypes);

        String token = jwtTokenUtil.generateAccessToken(users.getId(), users.getEmail());
        String link = "http://localhost:8080/api/v1/auth/verification/" + token;
        String content = String.format("Please click %s for verification", link);

        AuthData authData = new AuthData();
        authData.setToken(token);
        authData.setLink(link);
        authData.setContent(content);
        return authData;
    }

    public AuthDto login(AuthDto dto) {
        Optional<Users> optional = usersRepository
                .findByEmailAndPasswordAndDeletedAtIsNull(dto.getEmail(), PasswordService.generateMD5(dto.getPassword()));
        if (optional.isEmpty()){
            throw new CourseException("User not found");
        }
        Users users = optional.get();
        String token = jwtTokenUtil.generateAccessToken(users.getId(), users.getEmail());
        dto.setToken(token);
        return dto;
    }

    public UsersDto verification(String token) {
        String userName = jwtTokenUtil.getUserName(token);
        Optional<Users> optional = usersRepository.findByEmailAndDeletedAtIsNull(userName);
        if (optional.isEmpty()){
            throw new CourseException("User not found");
        }
        Users users = optional.get();
        users.setStatus(true);
        usersRepository.save(users);
        UsersDto dto = new UsersDto();
        dto.setEmail(users.getEmail());
        dto.setPassword(users.getPassword());
        dto.setName(users.getName());
        return dto;
    }
}
