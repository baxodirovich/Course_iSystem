package com.example.course_isystem.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class AuthData {
    @NotBlank(message = ("The Email cannot be empty or null"))
    private String email;
    @NotBlank(message = ("The Password cannot be empty or null"))
    private String password;
    @NotBlank(message = ("The Token cannot be empty or null"))
    private String token;
}
