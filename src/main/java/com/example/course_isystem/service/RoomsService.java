package com.example.course_isystem.service;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.dto.RoomsDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoomsService {
    public boolean create(RoomsDto roomsDto) {
        return false;
    }

    public RoomsDto get(Integer id) {
        return null;
    }

    public boolean update(Integer id, RoomsDto roomsDto) {
        return false;
    }

    public boolean delete(Integer id) {
        return false;
    }
}
