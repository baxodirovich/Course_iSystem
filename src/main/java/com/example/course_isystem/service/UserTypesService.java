package com.example.course_isystem.service;

import com.example.course_isystem.dto.UserTypesDto;
import com.example.course_isystem.exeption.CourseException;
import com.example.course_isystem.model.UserTypes;
import com.example.course_isystem.model.Users;
import com.example.course_isystem.repository.UserTypesRepository;
import com.example.course_isystem.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UserTypesService {
    private UserTypesRepository usersRepository;
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
        Optional<UserTypes> optional = usersRepository.findByIdAndDeletedAtIsNull(userTypesId);
        if (optional.isEmpty()) {
            throw new CourseException("Users Not Found");
        }
        return optional.get();
    }
}
