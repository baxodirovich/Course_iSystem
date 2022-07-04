package com.example.course_isystem.service;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.dto.UserTypesDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserTypesService {
    public boolean create(UserTypesDto userTypesDto) {
        return false;
    }

    public UserTypesDto get(Integer id) {
        return null;
    }

    public boolean update(Integer id, UserTypesDto userTypesDto) {
        return false;
    }

    public boolean delete(Integer id) {
        return false;
    }
}
