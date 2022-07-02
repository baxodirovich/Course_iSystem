package com.example.course_isystem.service;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.dto.GroupTypesDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroupTypesService {
    public boolean create(GroupTypesDto groupTypesDto) {
        return false;
    }

    public ClassesDto get(Integer id) {
        return null;
    }

    public boolean update(Integer id, GroupTypesDto groupTypesDto) {
        return false;
    }

    public boolean delete(Integer id) {
        return false;
    }
}
