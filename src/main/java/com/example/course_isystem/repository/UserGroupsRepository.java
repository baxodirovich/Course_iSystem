package com.example.course_isystem.repository;

import com.example.course_isystem.model.UserGroups;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface UserGroupsRepository extends JpaRepository<UserGroups, Integer> {
    Optional<UserGroups> findByIdAndDeletedAtIsNull(Integer userGroupsId);
}
