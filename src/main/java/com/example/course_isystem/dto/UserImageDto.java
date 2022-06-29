package com.example.course_isystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserImageDto {
    private Integer id;

    @NotBlank
    private String token;
    @NotBlank
    private String url;
    @NotBlank
    private String path;
    @NotBlank
    private String type;

    private Integer size;
    private Boolean status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;
}
