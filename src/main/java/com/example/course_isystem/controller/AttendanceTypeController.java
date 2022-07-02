package com.example.course_isystem.controller;

import com.example.course_isystem.dto.AttendanceTypeDto;
import com.example.course_isystem.service.AttendanceTypeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/attendance_type")
@AllArgsConstructor
public class AttendanceTypeController {
    private final AttendanceTypeService attendanceTypeService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid AttendanceTypeDto attendanceTypeDto){
        boolean result = attendanceTypeService.create(attendanceTypeDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        AttendanceTypeDto result = attendanceTypeService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,
                                    @RequestBody @Valid AttendanceTypeDto attendanceTypeDto){
        boolean result = attendanceTypeService.update(id, attendanceTypeDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = attendanceTypeService.delete(id);
        return ResponseEntity.ok(result);
    }
}
