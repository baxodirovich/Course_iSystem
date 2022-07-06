package com.example.course_isystem.repository;

import com.example.course_isystem.model.UserTypes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserTypesRepository extends JpaRepository<UserTypes, Integer> {
    Optional<UserTypes> findByIdAndDeletedAtIsNull(Integer userTypesId);
}
