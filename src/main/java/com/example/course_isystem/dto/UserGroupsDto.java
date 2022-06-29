package com.example.course_isystem.dto;

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

    private GroupDto groupDto;
    private Integer GroupId;

    private UsersDto usersDto;
    private Integer usersId;

    private TeacherDto teacherDto;
    private Integer teacherId;
}
