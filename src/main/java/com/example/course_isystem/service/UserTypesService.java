package com.example.course_isystem.service;

import com.example.course_isystem.dto.UserTypesDto;
import com.example.course_isystem.exeption.CourseException;
import com.example.course_isystem.model.UserTypes;
import com.example.course_isystem.repository.UserTypesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserTypesService {
    private UserTypesRepository usersRepository;
    public boolean create(UserTypesDto userTypesDto) {
        UserTypes userTypes = new UserTypes();
        userTypes.setId(userTypesDto.getId());
        userTypes.setStatus(true);
        userTypes.setCreatedAt(LocalDateTime.now());
        convertEntityToDto(userTypes, userTypesDto);
        usersRepository.save(userTypes);
        return true;
    }

    public UserTypesDto get(Integer id) {
        UserTypes userTypes = getEntity(id);
        UserTypesDto userTypesDto = new UserTypesDto();
        convertDtoToEntity(userTypes, userTypesDto);
        return userTypesDto;
    }

    public boolean update(Integer id, UserTypesDto userTypesDto) {
        UserTypes userTypes = getEntity(id);
        userTypes.setUpdatedAt(LocalDateTime.now());
        convertEntityToDto(userTypes, userTypesDto);
        usersRepository.save(userTypes);
        return true;
    }

    public boolean delete(Integer id) {
        UserTypes userTypes = getEntity(id);
        userTypes.setDeletedAt(LocalDateTime.now());
        usersRepository.save(userTypes);
        return true;
    }

    public UserTypes getEntity(Integer userTypesId) {
        Optional<UserTypes> optional = usersRepository.findByIdAndDeletedAtIsNull(userTypesId);
        if (optional.isEmpty()) {
            throw new CourseException("Users Types Not Found");
        }
        return optional.get();
    }

    private void convertDtoToEntity(UserTypes entity, UserTypesDto dto) {
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDisplayName(entity.getDisplayName());
    }

    private void convertEntityToDto(UserTypes entity, UserTypesDto dto) {
        entity.setName(dto.getName());
        entity.setDisplayName(dto.getDisplayName());
    }
}
