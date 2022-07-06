package com.example.course_isystem.dto;

import com.example.course_isystem.model.Group;
import com.example.course_isystem.model.Teacher;
import com.example.course_isystem.model.Users;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserGroupsDto {
    private Integer id;
    private Boolean status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    private Group group;
    private Integer GroupId;

    private Users users;
    private Integer usersId;

    private Teacher teacher;
    private Integer teacherId;
}
