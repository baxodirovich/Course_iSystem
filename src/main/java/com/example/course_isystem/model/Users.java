package com.example.course_isystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("users"))
public class Users {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String firstName;
    private String lastName;
    private String middleName;
    private Gender gender;
    private String phone;
    private String email;
    private String addressFirst;
    private String addressSecond;
    private String password;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = ("user_types_id"), insertable = false, updatable = false)
    private UserTypes userTypes;
    @Column(name = ("user_types_id"))
    private Integer userTypesId;

    @ManyToOne
    @JoinColumn(name = ("user_image_id"), insertable = false, updatable = false)
    private UserImage userImage;
    @Column(name = ("user_image_id"))
    private Integer userImageId;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
