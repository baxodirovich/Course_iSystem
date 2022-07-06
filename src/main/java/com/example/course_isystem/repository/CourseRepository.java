package com.example.course_isystem.repository;

import com.example.course_isystem.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
    Optional<Course> findByIdAndDeletedAtIsNull(Integer id);
}
