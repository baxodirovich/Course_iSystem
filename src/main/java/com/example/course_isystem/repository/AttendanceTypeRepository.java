package com.example.course_isystem.repository;

import com.example.course_isystem.model.AttendanceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AttendanceTypeRepository extends JpaRepository<AttendanceType, Integer> {
}
