package com.example.course_isystem.repository;

import com.example.course_isystem.model.AttendanceType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AttendanceTypeRepository extends JpaRepository<AttendanceType, Integer> {
    Optional<AttendanceType> finByIdAndDeletedAtIsNull(Integer id);
}
