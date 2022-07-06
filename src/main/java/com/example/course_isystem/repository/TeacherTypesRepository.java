package com.example.course_isystem.repository;

import com.example.course_isystem.model.TeacherTypes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherTypesRepository extends JpaRepository<TeacherTypes, Integer> {
    Optional<TeacherTypes> findByIdAndDeletedAtIsNull(Integer teacherTypesId);
}
