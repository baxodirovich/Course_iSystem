package com.example.course_isystem.repository;

import com.example.course_isystem.model.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface GroupRepository extends JpaRepository<Group, Integer> {
    Optional<Group> findByIdAndDeletedAtIsNull(Integer id);
}
