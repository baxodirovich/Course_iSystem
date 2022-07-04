package com.example.course_isystem.service;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.dto.UserGroupsDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserGroupsService {
    public boolean create(UserGroupsDto userGroupsDto) {
        return false;
    }

    public UserGroupsDto get(Integer id) {
        return null;
    }

    public boolean update(Integer id, UserGroupsDto userGroupsDto) {
        return false;
    }

    public boolean delete(Integer id) {
        return false;
    }
}
