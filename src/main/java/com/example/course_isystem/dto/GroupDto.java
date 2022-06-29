package com.example.course_isystem.dto;

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

    private CourseDto courseDto;
    private Integer courseId;

    private GroupTypesDto groupTypesDto;
    private Integer groupTypesId;
}
