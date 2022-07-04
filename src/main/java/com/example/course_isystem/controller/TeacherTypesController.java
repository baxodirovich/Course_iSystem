package com.example.course_isystem.controller;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.dto.TeacherTypesDto;
import com.example.course_isystem.service.TeacherTypesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/teacher_types")
@AllArgsConstructor
public class TeacherTypesController {
    private final TeacherTypesService teacherTypesService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid TeacherTypesDto teacherTypesDto){
        boolean result = teacherTypesService.create(teacherTypesDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        TeacherTypesDto result = teacherTypesService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,
                                    @RequestBody @Valid TeacherTypesDto teacherTypesDto){
        boolean result = teacherTypesService.update(id, teacherTypesDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = teacherTypesService.delete(id);
        return ResponseEntity.ok(result);
    }
}
