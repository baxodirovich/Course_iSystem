package com.example.course_isystem.service;

import com.example.course_isystem.dto.AttendanceTypeDto;
import com.example.course_isystem.exeption.CourseException;
import com.example.course_isystem.model.AttendanceType;
import com.example.course_isystem.repository.AttendanceTypeRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class AttendanceTypeService {
    private final AttendanceTypeRepository attendanceTypeRepository;
    public boolean create(AttendanceTypeDto attendanceTypeDto) {
        AttendanceType attendanceType = new AttendanceType();
        attendanceTypeDto.setId(attendanceType.getId());
        attendanceType.setStatus(true);
        attendanceType.setCreatedAt(LocalDateTime.now());
        convertDtoToEntity(attendanceTypeDto, attendanceType);
        attendanceTypeRepository.save(attendanceType);
        return true;
    }

    public AttendanceTypeDto get(Integer id) {
        AttendanceType attendanceType = getEntity(id);
        AttendanceTypeDto attendanceTypeDto = new AttendanceTypeDto();
        convertEntityToDto(attendanceType, attendanceTypeDto);
        return attendanceTypeDto;
    }

    public boolean update(Integer id, AttendanceTypeDto attendanceTypeDto) {
        AttendanceType update = getEntity(id);
        update.setUpdatedAt(LocalDateTime.now());
        convertDtoToEntity(attendanceTypeDto, update);
        attendanceTypeRepository.save(update);
        return true;
    }

    public boolean delete(Integer id) {
        AttendanceType attendanceType = getEntity(id);
        attendanceType.setDeletedAt(LocalDateTime.now());
        attendanceTypeRepository.save(attendanceType);
        return true;
    }

    AttendanceType getEntity(Integer id) {
        Optional<AttendanceType> optional = attendanceTypeRepository.findById(id);
        if (optional.isEmpty()){
            throw new CourseException("Attendance Type Not Found");
        }
        return optional.get();
    }

    private void convertDtoToEntity(AttendanceTypeDto dto, AttendanceType entity) {
        dto.setId(entity.getId());
        dto.setName(entity.getName());
        dto.setReasonMessage(entity.getReasonMessage());
    }

    private void convertEntityToDto(AttendanceType entity, AttendanceTypeDto dto) {
        entity.setId(dto.getId());
        entity.setName(dto.getName());
        entity.setReasonMessage(dto.getReasonMessage());
    }
}
