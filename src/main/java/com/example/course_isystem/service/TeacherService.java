package com.example.course_isystem.service;

import com.example.course_isystem.dto.TeacherDto;
import com.example.course_isystem.exeption.CourseException;
import com.example.course_isystem.model.Teacher;
import com.example.course_isystem.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    private final UsersService usersService;
    private final  TeacherTypesService teacherTypesService;
    public boolean create(TeacherDto teacherDto) {
        Teacher teacher = new Teacher();
        teacher.setId(teacherDto.getId());
        teacher.setStatus(true);
        teacher.setCreatedAt(LocalDateTime.now());
        teacher.setUsers(usersService.getEntity(teacherDto.getUsersId()));
        teacher.setTeacherTypes(teacherTypesService.getEntity(teacherDto.getTeacherTypesId()));
        convertEntityToDto(teacher, teacherDto);
        teacherRepository.save(teacher);
        return true;
    }

    public TeacherDto get(Integer id) {
        Teacher teacher = getEntity(id);
        TeacherDto teacherDto = new TeacherDto();
        teacherDto.setUsers(teacher.getUsers());
        teacherDto.setTeacherTypes(teacher.getTeacherTypes());
        convertDtoToEntity(teacherDto, teacher);
        return teacherDto;
    }

    public boolean update(Integer id, TeacherDto teacherDto) {
        Teacher teacher = getEntity(id);
        teacher.setUpdatedAt(LocalDateTime.now());
        teacher.setUsers(usersService.getEntity(teacherDto.getUsersId()));
        teacher.setTeacherTypes(teacherTypesService.getEntity(teacherDto.getTeacherTypesId()));
        convertEntityToDto(teacher, teacherDto);
        teacherRepository.save(teacher);
        return true;
    }

    public boolean delete(Integer id) {
        Teacher teacher = getEntity(id);
        teacher.setDeletedAt(LocalDateTime.now());
        teacherRepository.save(teacher);
        return true;
    }

    Teacher getEntity(Integer id) {
        Optional<Teacher> optional = teacherRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new CourseException("Teacher Not Found");
        }
        return optional.get();
    }

    private void convertDtoToEntity(TeacherDto dto, Teacher entity) {
        dto.setId(entity.getId());
    }

    private void convertEntityToDto(Teacher entity, TeacherDto dto) {
    }
}
