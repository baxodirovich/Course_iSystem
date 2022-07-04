package com.example.course_isystem.service;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.dto.UserTypesDto;
import com.example.course_isystem.exeption.CourseException;
import com.example.course_isystem.model.UserTypes;
import com.example.course_isystem.model.Users;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

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

    public UserTypes getEntity(Integer userTypesId) {
        Optional<Users> optional = usersRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new CourseException("Users Not Found");
        }
        return optional.get();
    }
}
