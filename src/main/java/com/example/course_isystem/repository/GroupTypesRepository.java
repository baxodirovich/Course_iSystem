package com.example.course_isystem.repository;

import com.example.course_isystem.model.GroupTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface GroupTypesRepository extends JpaRepository<GroupTypes, Integer> {
    Optional<GroupTypes> findByIdAndDeletedAtIsNull(Integer groupTypesId);
}
