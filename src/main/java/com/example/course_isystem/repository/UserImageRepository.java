package com.example.course_isystem.repository;

import com.example.course_isystem.model.UserImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserImageRepository extends JpaRepository<UserImage, Integer> {
    Optional<UserImage> findByIdAndDeletedAtIsNull(Integer id);

    Optional<UserImage> findByToken(String token);
}
