package com.example.course_isystem.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class RegisterDto {
    @NotBlank(message = ("The Email cannot be empty or null"))
    private String email;
    @NotBlank(message = ("The Password cannot be empty or null"))
    private String password;
    @NotBlank(message = ("The Contact cannot be empty or null"))
    private String phone;
}
