package com.example.course_isystem.service;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.dto.TeacherTypesDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class TeacherTypesService {
    public boolean create(TeacherTypesDto teacherTypesDto) {
        return false;
    }

    public ClassesDto get(Integer id) {
        return null;
    }

    public boolean update(Integer id, TeacherTypesDto teacherTypesDto) {
        return false;
    }

    public boolean delete(Integer id) {
        return false;
    }
}
