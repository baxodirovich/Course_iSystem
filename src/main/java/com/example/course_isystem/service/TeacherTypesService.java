package com.example.course_isystem.service;

import com.example.course_isystem.dto.TeacherTypesDto;
import com.example.course_isystem.exeption.CourseException;
import com.example.course_isystem.model.TeacherTypes;
import com.example.course_isystem.repository.TeacherTypesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherTypesService {
    private final TeacherTypesRepository teacherTypesRepository;

    public boolean create(TeacherTypesDto teacherTypesDto) {
        TeacherTypes teacherTypes = new TeacherTypes();
        teacherTypes.setId(teacherTypesDto.getId());
        teacherTypes.setStatus(true);
        teacherTypes.setCreatedAt(LocalDateTime.now());
        convertEntityToDto(teacherTypes, teacherTypesDto);
        teacherTypesRepository.save(teacherTypes);
        return true;
    }

    public TeacherTypesDto get(Integer id) {
        TeacherTypes teacherTypes = getEntity(id);
        TeacherTypesDto teacherTypesDto = new TeacherTypesDto();
        convertDtoToEntity(teacherTypesDto, teacherTypes);
        return teacherTypesDto;
    }

    public boolean update(Integer id, TeacherTypesDto teacherTypesDto) {
        TeacherTypes teacherTypes = getEntity(id);
        teacherTypes.setUpdatedAt(LocalDateTime.now());
        convertEntityToDto(teacherTypes, teacherTypesDto);
        teacherTypesRepository.save(teacherTypes);
        return true;
    }

    public boolean delete(Integer id) {
        TeacherTypes teacherTypes = getEntity(id);
        teacherTypes.setDeletedAt(LocalDateTime.now());
        teacherTypesRepository.save(teacherTypes);
        return true;
    }

    public TeacherTypes getEntity(Integer teacherTypesId) {
        Optional<TeacherTypes> optional = teacherTypesRepository.findByIdAndDeletedAtIsNull(teacherTypesId);
        if (optional.isEmpty()) {
            throw new CourseException("Teacher types Not Found");
        }
        return optional.get();
    }

    private void convertDtoToEntity(TeacherTypesDto dto, TeacherTypes entity) {
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setDisplayName(entity.getDisplayName());
    }

    private void convertEntityToDto(TeacherTypes entity, TeacherTypesDto dto) {
        entity.setName(dto.getName());
        entity.setDisplayName(dto.getDisplayName());
    }
}
