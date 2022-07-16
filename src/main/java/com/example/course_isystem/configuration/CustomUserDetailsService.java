package com.example.course_isystem.configuration;

import com.example.course_isystem.exeption.CourseException;
import com.example.course_isystem.model.Users;
import com.example.course_isystem.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

// Management (foydalanuvchilar boshqaruvi) un jabob beradi
@Component
@AllArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {
    private UsersRepository usersRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Users> optional = usersRepository.findByEmailAndDeletedAtIsNull(username);
        if (optional.isEmpty()){
            throw new CourseException("User not found");
        }
        Users users = optional.get();
        return new CustomUserDetails(users);
    }
}
