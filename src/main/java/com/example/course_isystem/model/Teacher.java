package com.example.course_isystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("teacher"))
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = ("users_id"), insertable = false, updatable = false)
    private Users users;
    @Column(name = ("users_id"))
    private Integer usersId;

    @ManyToOne
    @JoinColumn(name = ("teacher_types_id"), insertable = false, updatable = false)
    private TeacherTypes teacherTypes;
    @Column(name = ("teacher_type_id"))
    private Integer teacherTypesId;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
