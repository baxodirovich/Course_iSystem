package com.example.course_isystem.repository;

import com.example.course_isystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CourseRepository extends JpaRepository<Course, Integer> {
    Optional<Course> findByIdAndDeletedAtIsNull(Integer id);
}
