package com.example.course_isystem.repository;

import com.example.course_isystem.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
    Optional<Teacher> findByIdAndDeletedAtIsNull(Integer id);
}
