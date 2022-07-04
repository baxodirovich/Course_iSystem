package com.example.course_isystem.repository;

import com.example.course_isystem.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByIdAndDeletedAtIsNull(Integer id);
}
