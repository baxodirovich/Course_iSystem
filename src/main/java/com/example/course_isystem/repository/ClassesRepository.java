package com.example.course_isystem.repository;

import com.example.course_isystem.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ClassesRepository extends JpaRepository<Classes, Integer> {
    Optional<Classes> findByIdAndDeletedAtIsNull(Integer id);
}
