package com.example.course_isystem.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter

@Entity
@Table(name = ("classes"))
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private LocalDate data;
    private Boolean status;

    @ManyToOne
    @JoinColumn(name = ("room_id"), insertable = false, updatable = false)
    private Rooms rooms;
    @Column(name = ("rooms_id"))
    private Integer roomsId;

    @ManyToOne
    @JoinColumn(name = ("user_groups_id"), insertable = false, updatable = false)
    private UserGroups userGroups;
    @Column(name = ("user_groups_id"))
    private Integer userGroupsId;

    @ManyToOne
    @JoinColumn(name = ("attendance_type_id"), insertable = false, updatable = false)
    private AttendanceType attendanceType;
    @Column(name = ("attendance_type_id"))
    private Integer attendanceTypeId;

    @Column(name = ("created_at"))
    private LocalDateTime createdAt;

    @Column(name = ("updated_at"))
    private LocalDateTime updatedAt;

    @Column(name = ("deleted_at"))
    private LocalDateTime deletedAt;
}
