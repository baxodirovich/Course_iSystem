package com.example.course_isystem.service;

import com.example.course_isystem.dto.ClassesDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ClassesService {
    public boolean create(ClassesDto classesDto) {
        return false;
    }

    public ClassesDto get(Integer id) {
        return null;
    }

    public boolean update(Integer id, ClassesDto classesDto) {
        return false;
    }

    public boolean delete(Integer id) {
        return false;
    }
}
