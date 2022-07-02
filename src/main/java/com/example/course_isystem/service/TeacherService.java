package com.example.course_isystem.service;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.dto.TeacherDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherService {
    public boolean create(TeacherDto teacherDto) {
        return false;
    }

    public ClassesDto get(Integer id) {
        return null;
    }

    public boolean update(Integer id, TeacherDto teacherDto) {
        return false;
    }

    public boolean delete(Integer id) {
        return false;
    }
}
