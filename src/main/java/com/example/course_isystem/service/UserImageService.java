package com.example.course_isystem.service;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.dto.UserImageDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserImageService {
    public boolean create(UserImageDto userImageDto) {
        return false;
    }

    public ClassesDto get(Integer id) {
        return null;
    }

    public boolean update(Integer id, UserImageDto userImageDto) {
        return false;
    }

    public boolean delete(Integer id) {
        return false;
    }
}
