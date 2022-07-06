package com.example.course_isystem.repository;

import com.example.course_isystem.model.TeacherTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TeacherTypesRepository extends JpaRepository<TeacherTypes, Integer> {
    Optional<TeacherTypes> findByIdAndDeletedAtIsNull(Integer teacherTypesId);
}
