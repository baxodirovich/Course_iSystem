package com.example.course_isystem.dto;

import com.example.course_isystem.model.AttendanceType;
import com.example.course_isystem.model.Rooms;
import com.example.course_isystem.model.UserGroups;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClassesDto {
    private Integer id;

    @NotBlank
    private String name;

    private LocalDate data;
    private Boolean status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    private Rooms rooms;
    private Integer roomsId;

    private UserGroups userGroups;
    private Integer userGroupsId;

    private AttendanceType attendanceType;
    private Integer attendanceTypeId;
}
