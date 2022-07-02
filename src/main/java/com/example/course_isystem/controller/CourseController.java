package com.example.course_isystem.controller;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.dto.CourseDto;
import com.example.course_isystem.service.CourseService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/course")
@AllArgsConstructor
public class CourseController {
    private final CourseService courseService;
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid CourseDto courseDto){
        boolean result = courseService.create(courseDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        ClassesDto result = courseService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,
                                    @RequestBody @Valid CourseDto courseDto){
        boolean result = courseService.update(id, courseDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = courseService.delete(id);
        return ResponseEntity.ok(result);
    }
}
