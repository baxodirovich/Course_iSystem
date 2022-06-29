package com.example.course_isystem.repository;

import com.example.course_isystem.model.UserGroups;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserGroupsRepository extends JpaRepository<UserGroups, Integer> {
}
