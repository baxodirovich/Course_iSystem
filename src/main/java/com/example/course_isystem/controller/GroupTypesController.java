package com.example.course_isystem.controller;

import com.example.course_isystem.dto.ClassesDto;
import com.example.course_isystem.dto.GroupTypesDto;
import com.example.course_isystem.service.GroupTypesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/group_types")
@AllArgsConstructor
public class GroupTypesController {
    private final GroupTypesService groupTypesService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid GroupTypesDto groupTypesDto){
        boolean result = groupTypesService.create(groupTypesDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        ClassesDto result = groupTypesService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,
                                    @RequestBody @Valid GroupTypesDto groupTypesDto){
        boolean result = groupTypesService.update(id, groupTypesDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = groupTypesService.delete(id);
        return ResponseEntity.ok(result);
    }
}
