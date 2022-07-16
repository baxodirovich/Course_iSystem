package com.example.course_isystem.repository;

import com.example.course_isystem.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByEmailAndDeletedAtIsNull(String userName);

    Optional<Users> findByIdAndDeletedAtIsNull(Integer id);

    Optional<Users> findByEmailOrPhoneAndDeletedAtIsNull(String email, String phone);

    Optional<Users> findByEmailAndPasswordAndDeletedAtIsNull(String email, String generateMD5);
}
