package com.example.course_isystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserTypesDto {
    private Integer id;

    @NotBlank
    private String name;
    @NotBlank
    private String displayName;

    private Boolean status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
