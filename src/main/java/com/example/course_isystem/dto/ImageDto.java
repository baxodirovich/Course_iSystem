package com.example.course_isystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ImageDto {
    private Integer id;
    @NotBlank(message = ("The token cannot be empty or null"))
    private String token;
    @NotBlank(message = ("The url cannot be empty or null"))
    private String url;
    @NotBlank(message = ("The path cannot be empty or null"))
    private String path;
    @NotBlank(message = ("The type cannot be empty or null"))
    private String type;
    @NotBlank(message = ("The size cannot be empty or null"))
    private Long size;
}
