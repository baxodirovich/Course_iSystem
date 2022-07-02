package com.example.course_isystem.service;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.dto.CourseDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CourseService {
    public boolean create(CourseDto courseDto) {
        return false;
    }

    public ClassesDto get(Integer id) {
        return null;
    }

    public boolean update(Integer id, CourseDto courseDto) {
        return false;
    }

    public boolean delete(Integer id) {
        return false;
    }
}
