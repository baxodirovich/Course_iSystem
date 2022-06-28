package com.example.course_isystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("user_groups"))
public class UserGroups {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = ("group_id"), insertable = false, updatable = false)
    private Group group;
    @Column(name = ("group_id"))
    private Integer groupId;

    @ManyToOne
    @JoinColumn(name = ("users_id"), insertable = false, updatable = false)
    private Users users;
    @Column(name = ("user_id"))
    private Integer userId;

    @ManyToOne
    @JoinColumn(name = ("teacher_id"), insertable = false, updatable = false)
    private Teacher teacher;
    @Column(name = ("teacher_id"))
    private Integer teacherId;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
