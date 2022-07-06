package com.example.course_isystem.service;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.exeption.CourseException;
import com.example.course_isystem.model.Classes;
import com.example.course_isystem.repository.ClassesRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ClassesService {
    private final RoomsService roomsService;
    private final UserGroupsService userGroupsService;
    private final AttendanceTypeService attendanceTypeService;
    private final ClassesRepository classesRepository;

    public boolean create(ClassesDto classesDto) {
        Classes classes = new Classes();
        classes.setId(classesDto.getId());
        classes.setStatus(true);
        classes.setCreatedAt(LocalDateTime.now());
        classes.setRooms(roomsService.getEntity(classesDto.getRoomsId()));
        classes.setUserGroups(userGroupsService.getEntity(classesDto.getUserGroupsId()));
        classes.setAttendanceType(attendanceTypeService.getEntity(classesDto.getAttendanceTypeId()));
        convertEntityToDto(classes, classesDto);
        classesRepository.save(classes);
        return true;
    }

    public ClassesDto get(Integer id) {
        Classes classes = getEntity(id);
        ClassesDto classesDto = new ClassesDto();
        classesDto.setRooms(classes.getRooms());
        classesDto.setUserGroups(classes.getUserGroups());
        classesDto.setAttendanceType(classes.getAttendanceType());
        convertDtoToEntity(classesDto, classes);
        return classesDto;
    }

    public boolean update(Integer id, ClassesDto classesDto) {
        Classes classes = getEntity(id);
        classes.setUpdatedAt(LocalDateTime.now());
        classes.setRooms(roomsService.getEntity(classesDto.getRoomsId()));
        classes.setUserGroups(userGroupsService.getEntity(classesDto.getUserGroupsId()));
        classes.setAttendanceType(attendanceTypeService.getEntity(classesDto.getAttendanceTypeId()));
        convertEntityToDto(classes, classesDto);
        classesRepository.save(classes);
        return true;
    }

    public boolean delete(Integer id) {
        Classes classes = getEntity(id);
        classes.setDeletedAt(LocalDateTime.now());
        classesRepository.save(classes);
        return true;
    }

    private Classes getEntity(Integer id) {
        Optional<Classes> optional = classesRepository.findByIdAndDeletedAtIsNull(id);
        if (optional.isEmpty()) {
            throw new CourseException("Classes Not Found");
        }
        return optional.get();
    }

    private void convertDtoToEntity(ClassesDto dto, Classes entity) {
        dto.setId(entity.getId());
        dto.setName(entity.getName());
    }

    private void convertEntityToDto(Classes entity, ClassesDto dto) {
        entity.setName(dto.getName());
    }
}
