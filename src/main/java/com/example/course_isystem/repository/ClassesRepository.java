package com.example.course_isystem.repository;

import com.example.course_isystem.model.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface ClassesRepository extends JpaRepository<Classes, Integer> {
    Optional<Classes> findByIdAndDeletedAtIsNull(Integer id);
}
