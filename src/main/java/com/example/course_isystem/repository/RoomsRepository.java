package com.example.course_isystem.repository;

import com.example.course_isystem.model.Rooms;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface RoomsRepository extends JpaRepository<Rooms, Integer> {
    Optional<Rooms> findByIdAndDeletedAtIsNull(Integer roomsId);
}
