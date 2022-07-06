package com.example.course_isystem.repository;

import com.example.course_isystem.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoomsRepository extends JpaRepository<Rooms, Integer> {
    Optional<Rooms> findByIdAndDeletedAtIsNull(Integer roomsId);
}
