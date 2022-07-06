package com.example.course_isystem.repository;

import com.example.course_isystem.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Optional<Teacher> findByIdAndDeletedAtIsNull(Integer id);
}
