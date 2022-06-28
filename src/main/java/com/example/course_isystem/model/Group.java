package com.example.course_isystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("group"))
public class Group {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = ("course_id"), insertable = false, updatable = false)
    private Course course;
    @Column(name = ("course_id"))
    private Integer courseId;

    @ManyToOne
    @JoinColumn(name = ("group_types_id"), insertable = false, updatable = false)
    private GroupTypes groupTypes;
    @Column(name = ("group_types_id"))
    private Integer groupTypesId;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
