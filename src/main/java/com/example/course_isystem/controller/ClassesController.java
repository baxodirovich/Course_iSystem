package com.example.course_isystem.controller;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.service.ClassesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/classes")
@AllArgsConstructor
public class ClassesController {
    private final ClassesService classesService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid ClassesDto classesDto){
        boolean result = classesService.create(classesDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        ClassesDto result = classesService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,
                                    @RequestBody @Valid ClassesDto classesDto){
        boolean result = classesService.update(id, classesDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = classesService.delete(id);
        return ResponseEntity.ok(result);
    }
}
