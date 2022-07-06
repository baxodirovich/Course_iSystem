package com.example.course_isystem.dto;

import com.example.course_isystem.model.Course;
import com.example.course_isystem.model.GroupTypes;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GroupDto {
    private Integer id;

    @NotBlank
    private String name;

    private Boolean status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    private Course course;
    private Integer courseId;

    private GroupTypes groupTypes;
    private Integer groupTypesId;
}
