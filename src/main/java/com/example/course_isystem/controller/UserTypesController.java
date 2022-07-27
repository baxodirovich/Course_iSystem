package com.example.course_isystem.controller;

import com.example.course_isystem.dto.UserTypesDto;
import com.example.course_isystem.service.UserTypesService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/user_types")
@AllArgsConstructor
public class UserTypesController {

    private final UserTypesService userTypesService;

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody @Valid UserTypesDto userTypesDto){
        boolean result = userTypesService.create(userTypesDto);
        return ResponseEntity.ok(result);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable("id") Integer id){
        UserTypesDto result = userTypesService.get(id);
        return ResponseEntity.ok(result);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Integer id,
                                    @RequestBody @Valid UserTypesDto userTypesDto){
        boolean result = userTypesService.update(id, userTypesDto);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Integer id){
        boolean result = userTypesService.delete(id);
        return ResponseEntity.ok(result);
    }
}
