package com.example.course_isystem.repository;

import com.example.course_isystem.model.AttendanceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
@Repository

public interface AttendanceTypeRepository extends JpaRepository<AttendanceType, Integer> {
    Optional<AttendanceType> findByIdAndDeletedAtIsNull(Integer id);
}
