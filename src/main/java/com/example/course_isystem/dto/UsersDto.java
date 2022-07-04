package com.example.course_isystem.dto;

import com.example.course_isystem.model.Gender;
import com.example.course_isystem.model.UserImage;
import com.example.course_isystem.model.UserTypes;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UsersDto {
    private Integer id;
    private Boolean status;

    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private LocalDateTime deletedAt;

    @NotBlank
    private Gender gender;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;
    @NotBlank
    private String middleName;
    @NotBlank
    private String phone;
    @NotBlank
    private String email;
    @NotBlank
    private String addressFirst;
    @NotBlank
    private String addressSecond;
    @NotBlank
    private String password;

    private UserTypes userTypes;
    private Integer userTypesId;

    private UserImage userImage;
    private Integer userImageId;


}
