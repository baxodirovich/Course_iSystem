package com.example.course_isystem.service;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.dto.GroupTypesDto;
import com.example.course_isystem.exeption.CourseException;
import com.example.course_isystem.model.GroupTypes;
import com.example.course_isystem.model.Users;
import com.example.course_isystem.repository.GroupTypesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class GroupTypesService {
    private final GroupTypesRepository groupTypesRepository;

    public boolean create(GroupTypesDto groupTypesDto) {
        GroupTypes groupTypes = new GroupTypes();
        groupTypes.setId(groupTypesDto.getId());
        groupTypes.setStatus(true);
        groupTypes.setCreatedAt(LocalDateTime.now());
        convertEntityToDto(groupTypes, groupTypesDto);
        groupTypesRepository.save(groupTypes);
        return true;
    }

    public GroupTypesDto get(Integer id) {
        GroupTypes groupTypes = getEntity(id);
        GroupTypesDto groupTypesDto = new GroupTypesDto();
        convertDtoToEntity(groupTypesDto, groupTypes);
        return groupTypesDto;
    }

    public boolean update(Integer id, GroupTypesDto groupTypesDto) {
        GroupTypes groupTypes = getEntity(id);
        groupTypes.setUpdatedAt(LocalDateTime.now());
        convertEntityToDto(groupTypes, groupTypesDto);
        groupTypesRepository.save(groupTypes);
        return true;
    }

    public boolean delete(Integer id) {
        GroupTypes groupTypes = getEntity(id);
        groupTypes.setDeletedAt(LocalDateTime.now());
        groupTypesRepository.save(groupTypes);
        return true;
    }

    public GroupTypes getEntity(Integer groupTypesId) {
        Optional<GroupTypes> optional = groupTypesRepository.findByIdAndDeletedAtIsNull(groupTypesId);
        if (optional.isEmpty()) {
            throw new CourseException("Users Not Found");
        }
        return optional.get();
    }

    private void convertDtoToEntity(GroupTypesDto dto, GroupTypes entity) {
        dto.setId(entity.getId());
        dto.setName(entity.getName());
    }

    private void convertEntityToDto(GroupTypes entity, GroupTypesDto dto) {
        entity.setName(dto.getName());
    }
}
