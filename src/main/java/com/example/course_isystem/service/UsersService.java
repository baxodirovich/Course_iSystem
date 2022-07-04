package com.example.course_isystem.service;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.dto.UsersDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersService {
    public boolean create(UsersDto usersDto) {
        return false;
    }

    public UsersDto get(Integer id) {
        return null;
    }

    public boolean update(Integer id, UsersDto usersDto) {
        return false;
    }

    public boolean delete(Integer id) {
        return false;
    }
}
