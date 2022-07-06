package com.example.course_isystem.service;

import com.example.course_isystem.dto.RoomsDto;
import com.example.course_isystem.exeption.CourseException;
import com.example.course_isystem.model.Rooms;
import com.example.course_isystem.repository.RoomsRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@AllArgsConstructor
public class RoomsService {
    private final RoomsRepository roomsRepository;

    public boolean create(RoomsDto roomsDto) {
        Rooms rooms = new Rooms();
        rooms.setId(roomsDto.getId());
        rooms.setStatus(true);
        rooms.setCreatedAt(LocalDateTime.now());
        convertEntityToDto(rooms, roomsDto);
        roomsRepository.save(rooms);
        return true;
    }

    public RoomsDto get(Integer id) {
        Rooms rooms = getEntity(id);
        RoomsDto roomsDto = new RoomsDto();
        convertDtoToEntity(roomsDto, rooms);
        return roomsDto;
    }

    public boolean update(Integer id, RoomsDto roomsDto) {
        Rooms rooms = getEntity(id);
        rooms.setUpdatedAt(LocalDateTime.now());
        convertEntityToDto(rooms, roomsDto);
        roomsRepository.save(rooms);
        return true;
    }

    public boolean delete(Integer id) {
        Rooms rooms = getEntity(id);
        rooms.setDeletedAt(LocalDateTime.now());
        roomsRepository.save(rooms);
        return true;
    }

    public Rooms getEntity(Integer roomsId) {
        Optional<Rooms> optional = roomsRepository.findByIdAndDeletedAtIsNull(roomsId);
        if (optional.isEmpty()) {
            throw new CourseException("Users Not Found");
        }
        return optional.get();
    }

    private void convertDtoToEntity(RoomsDto dto, Rooms entity) {
        dto.setId(entity.getId());
        dto.setName(entity.getName());
    }

    private void convertEntityToDto(Rooms entity, RoomsDto dto) {
        entity.setName(dto.getName());
    }
}
