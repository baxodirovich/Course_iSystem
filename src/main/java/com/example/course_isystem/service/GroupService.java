package com.example.course_isystem.service;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.dto.GroupDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class GroupService {
    public boolean create(GroupDto groupDto) {
        return false;
    }

    public GroupDto get(Integer id) {
        return null;
    }

    public boolean update(Integer id, GroupDto groupDto) {
        return false;
    }

    public boolean delete(Integer id) {
        return false;
    }
}
